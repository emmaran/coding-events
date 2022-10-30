package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

//    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description is too long!")
    private String description;

    @Email(message = "Invalid email. Try again.")
    @NotBlank(message = "Email is required.")
    private String contactEmail;

//    @NotBlank(message = "Location cannot be left blank.")
//    private String location;

//    @AssertTrue
//    private boolean registrationStatus;

//    @Positive(message = "Number of attendees must be one or more.")
//    private int numberOfAttendees;

    private EventType type;

    public Event(String name, String description, String contactEmail,
//                 String location, boolean registrationStatus, int numberOfAttendees,
                 EventType type) {
//        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
//        this.location = location;
//        this.registrationStatus = registrationStatus;
//        this.numberOfAttendees = numberOfAttendees;
        this.type = type;
    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
