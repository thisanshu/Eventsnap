import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Event {
    String name;
    String date;
    List<String> attendees;
    public Event(String name, String date) {
        this.name = name;
        this.date = date;
        this.attendees = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public List<String> getAttendees() {
        return attendees;
    }
    public void addAttendee(String attendee) {
        attendees.add(attendee);
    }
    public void removeAttendee(String attendee) {
        attendees.remove(attendee);
    }
}
class EventPlanner {
    List<Event> events;
    public EventPlanner() {
        events = new ArrayList<>();
    }
    public void createEvent(String name, String date) {
        Event event = new Event(name, date);
        events.add(event);
    }
    public void addAttendee(String eventName, String attendee) {
        Event event = findEvent(eventName);
        if (event != null) {
            event.addAttendee(attendee);
            System.out.println("Attendee added successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }
    public void removeAttendee(String eventName, String attendee) {
        Event event = findEvent(eventName);
        if (event != null) {
            event.removeAttendee(attendee);
            System.out.println("Attendee removed successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }
    public void generateEventReport(String eventName) {
        Event event = findEvent(eventName);
        if (event != null) {
            System.out.println("Event: " + event.getName());
            System.out.println("Date: " + event.getDate());
            System.out.println("Attendees: " + event.getAttendees());
        } else {
            System.out.println("Event not found.");
        }
    }
    Event findEvent(String eventName) {
        for (Event event : events) {
            if (event.getName().equals(eventName)) {
                return event;
            }
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        EventPlanner eventPlanner = new EventPlanner();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<Event Planning System>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("=============================CHOICES==================================");
            System.out.println("1. Create Event \t\t\t 2. Add Attendee \t\t\t 3.Remove Attendee");
            System.out.println();
            System.out.println("4. Generate Event Report \t\t\t 5.Exit");
            System.out.println();
            System.out.println("=========================================================================");
            System.out.println("Enter your choice: ");
            int choice =sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String eventName = sc.nextLine();
                    System.out.print("Enter event date: ");
                    String eventDate = sc.nextLine();
                    eventPlanner.createEvent(eventName, eventDate);
                    System.out.println("Event created.");
                    break;
                case 2:
                    System.out.print("Enter event name: ");
                    eventName = sc.nextLine();
                    System.out.print("Enter attendee name: ");
                    String attendeeName = sc.nextLine();
                    eventPlanner.addAttendee(eventName, attendeeName);
                    break;
                case 3:
                    System.out.print("Enter event name: ");
                    eventName = sc.nextLine();
                    System.out.print("Enter attendee name: ");
                    attendeeName = sc.nextLine();
                    eventPlanner.removeAttendee(eventName, attendeeName);
                    break;
                case 4:
                    System.out.print("Enter event name: ");
                    eventName = sc.nextLine();
                    eventPlanner.generateEventReport(eventName);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid.Please try again later.");
            }
        }
    }
}

