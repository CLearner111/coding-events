package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<Event> events = new ArrayList<>();
//    events.add("Code With Pride");

    @GetMapping
    public String displayAllEvents(Model model) {
//        List<String> events = new ArrayList<>();
//        events.add("Code With Pride");
//        events.add("Strange Loop");
//        events.add("Apple WWDC");
//        events.add("SpringOne Platform");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

//    @PostMapping("create")
//    public String createEvent(@RequestParam String eventName,
//                              @RequestParam String eventDescription) {
//        EventData.add(new Event(eventName,eventDescription));
//        return "redirect:"; //redirects to the root of the controller
//    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:"; //redirects to the root of the controller
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) int[] eventIds) {
        if(eventIds != null) {
            for(int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:"; //redirects to the root of the controller
    }

    @GetMapping("edit")
    public String displayEditEventForm(Model model) {
        model.addAttribute("title", "Edit Events");
        model.addAttribute("events", EventData.getAll());
        return "events/edit";
    }

    @PostMapping("edit")
    public String editEvent(@RequestParam(required = false) int[] eventIds) {
        if(eventIds != null) {
            for(int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:"; //redirects to the root of the controller
    }



}