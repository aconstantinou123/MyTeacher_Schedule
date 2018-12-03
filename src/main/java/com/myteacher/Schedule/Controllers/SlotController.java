package com.myteacher.Schedule.Controllers;


import com.myteacher.Schedule.Models.Slot;
import com.myteacher.Schedule.Repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SlotController {
    @Autowired
    SlotRepository slotRepository;

    @PreAuthorize("hasAuthority('TEACHER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public List<Slot> getByUserName(@PathVariable("username") String username){
        return slotRepository.findAllByUsername(username);
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<Slot> createNewSlot(@RequestBody List<Slot> slots){
        for(Slot slot : slots){
            slot.setStudents(new ArrayList<String>());
        }
        slotRepository.saveAll(slots);
        return slotRepository.findAllByUsername(slots.get(0).getUsername());
    }
}
