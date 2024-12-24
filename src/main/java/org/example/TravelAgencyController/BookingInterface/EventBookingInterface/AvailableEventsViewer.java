package org.example.TravelAgencyController.BookingInterface.EventBookingInterface;

import org.example.TravelAgencyApplication.BookingManagement.EventBooking.EventRetriever;
import org.example.TravelAgencyPersistence.BookingStore.ExternalEventProvider.Event;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@RestController
@RequestMapping("/events")
public class AvailableEventsViewer {
    private EventRetriever eventRetriever;

    public AvailableEventsViewer() {
        eventRetriever = EventRetriever.getInstance();
    }

    @GetMapping({"", "/"})
    public ArrayList<Event> getAllEvents() {
        return eventRetriever.getAllEvents();
    }

    @GetMapping("/{eventID}")
    public Event getEventByID(@PathVariable Integer eventID) {
        return eventRetriever.getEventByID(eventID);
    }

    @GetMapping("/search")
    public ArrayList<Event> getFilteredEvents(
            @RequestParam(name = "minDate", defaultValue = "0000-1-1") String minDate,
            @RequestParam(name = "maxDate", defaultValue = "9999-1-1") String maxDate,
            @RequestParam(name = "minPrice", defaultValue = "0") Integer minPrice,
            @RequestParam(name = "maxPrice", defaultValue = "1000000") Integer maxPrice,
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "desc", defaultValue = "") String desc) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return eventRetriever.getFilteredEvents(null, dateFormat.parse(minDate), dateFormat.parse(maxDate), name, desc, minPrice, maxPrice);
    }

    @GetMapping("/near")
    public ArrayList<Event> getEventsWithinRadius(@RequestParam(name = "lat") double latitude,
                                                  @RequestParam(name = "long") double longitude,
                                                  @RequestParam(name = "radius", defaultValue = "5") double radius) {
        return eventRetriever.getEventsWithinRadius(latitude, longitude, radius);
    }
}