package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity {


//    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();


//    @NotBlank(message = "Location cannot be left blank.")
//    private String location;

//    @AssertTrue
//    private boolean registrationStatus;

//    @Positive(message = "Number of attendees must be one or more.")
//    private int numberOfAttendees;

    @ManyToOne
    @NotNull(message = "Category is required.")
    private EventCategory eventCategory;

    public Event(String name,
//                 String description, String contactEmail,
//                 String location, boolean registrationStatus, int numberOfAttendees,
                 EventCategory eventCategory) {
//        this();
        this.name = name;
//        this.description = description;
//        this.contactEmail = contactEmail;
//        this.location = location;
//        this.registrationStatus = registrationStatus;
//        this.numberOfAttendees = numberOfAttendees;
        this.eventCategory = eventCategory;
    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

//    public boolean getRegistrationStatus() {
//        return registrationStatus;
//    }
//
//    public void setRegistrationStatus(boolean registrationStatus) {
//        this.registrationStatus = registrationStatus;
//    }
//
//    public int getNumberOfAttendees() {
//        return numberOfAttendees;
//    }
//
//    public void setNumberOfAttendees(int numberOfAttendees) {
//        this.numberOfAttendees = numberOfAttendees;
//    }


    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return name;
    }

}
