package skibsted.eventplan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skibsted.eventplan.model.Band;
import skibsted.eventplan.model.Event;
import skibsted.eventplan.service.IBandService;
import skibsted.eventplan.service.IEventService;

import java.util.Optional;
import java.util.Set;

@RestController
public class EventController {

    private IEventService eventService;
    private IBandService bandService;

    public EventController(IEventService eventService, IBandService bandService) {
        this.eventService = eventService;
        this.bandService = bandService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event event, @RequestParam Long bandID) {
        String msg="";
        Optional<Band> band_ = bandService.findById(bandID);
        if(band_.isPresent())  {
            event.setBand(band_.get());
            eventService.save(event);
            msg="Oprettet event: " + event.getVenue();
        }else {
            msg="fejl i oprettelsen af " + event.getVenue();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
    @GetMapping("/getEvents")
    public ResponseEntity<Set<Event>> getEvents() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }
}
