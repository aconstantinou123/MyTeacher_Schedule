package com.myteacher.Schedule.Controllers;


import com.myteacher.Schedule.Models.Slot;
import com.myteacher.Schedule.Repositories.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SlotController {
    @Autowired
    SlotRepository slotRepository;

//    @PreAuthorize("hasAuthority('TEACHER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Slot> getAllSlots() {
        System.out.println("here");
        return slotRepository.findAll();
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public List<Slot> getByUserName(@PathVariable("username") String username){
        System.out.println("username " + username);
        return slotRepository.findAllByUsername(username);
    }
}
