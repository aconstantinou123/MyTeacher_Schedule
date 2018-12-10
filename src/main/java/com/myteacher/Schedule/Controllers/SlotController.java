package com.myteacher.Schedule.Controllers;


import com.myteacher.Schedule.Models.Slot;
import com.myteacher.Schedule.Repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SlotController {
    @Autowired
    SlotRepository slotRepository;

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public List<Slot> getByUserName(@PathVariable("username") String username){
        return slotRepository.findAllByUsername(username);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<Slot> createNewSlot(@RequestBody List<Slot> slots){
        for(Slot slot : slots){
            slot.setStudents(new ArrayList<String>());
        }
        slotRepository.saveAll(slots);
        return slotRepository.findAllByUsername(slots.get(0).getUsername());
    }

    @PreAuthorize("hasRole('TEACHER')")
    
    @RequestMapping(value = "/{username}/{classId}", method = RequestMethod.DELETE)
    public List<Slot> deleteSlotByClassId(@PathVariable("classId") String classId, @PathVariable("username") String username){
        slotRepository.deleteAllByClassId(classId);
        return slotRepository.findAllByUsername(username);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public List<Slot> updateClass(@RequestBody List<Slot> slots){
        slotRepository.deleteAllByClassId(slots.get(0).getClassId());
        ArrayList<String> students = slots.get(0).getStudents();
        for(Slot slot : slots){
            slot.setStudents(students);
        }
        slotRepository.saveAll(slots);
        return slotRepository.findAllByUsername(slots.get(0).getUsername());
    }

    @PreAuthorize("hasRole('STUDENT')")
    @RequestMapping(value = "/slots/{classLevel}", method = RequestMethod.GET)
    public List<Slot> getSlotsByLevel(@PathVariable("classLevel") String classLevel){
        List<Slot> slotsToReturn = new ArrayList<>();
        List<Slot> slotsFound = slotRepository.findAllByClassLevel(classLevel);
        List<Slot> unspecifiedSlots = slotRepository.findAllByClassLevel("NONE_SPECIFIED");
        slotsFound.addAll(unspecifiedSlots);
        for(Slot slot : slotsFound){
            try{
                String dateAndTime = slot.getDate() + " " + slot.getStartTime();
                if (new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(dateAndTime).after(new Date())) {
                    slotsToReturn.add(slot);
                }

            }
            catch (ParseException e){
                e.printStackTrace();
            }
        }
        return slotsToReturn;
    }
}
