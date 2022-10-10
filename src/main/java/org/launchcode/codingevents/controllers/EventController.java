package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<String> events = new ArrayList<>();
//    private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        // first attempt
//        ArrayList<String> events = new ArrayList<>();
//        events.add("Code With Pride");
//        events.add("Strange Loop");
//        events.add("Apple WWDC");
//        events.add("SpringOne Platform");
//        model.addAttribute("events", events);
        // second attempt
//        model.addAttribute("events", events);
//        return "events/index";
        //third attempt
//        HashMap<String, String> events = new HashMap<>();
//        events.put("Menteaship","A fun meetup for connecting with mentors");
//        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
//        events.put("Javascripty", "An imaginary meetup for Javascript developers");
        model.addAttribute("events", EventData.getAll());
        return "events/index";

    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

//    lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        EventData.add(newEvent);
        return "redirect:";
    }

    //lives at events/delete
    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event eventToEdit = EventData.getById(eventId);
        model.addAttribute("event", eventToEdit);
        String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
        model.addAttribute("title", title);

        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description, String contactEmail) {
        Event eventToEdit = EventData.getById(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        eventToEdit.setContactEmail(contactEmail);

        return "redirect:";
    }

}
