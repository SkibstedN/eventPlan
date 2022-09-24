package skibsted.eventplan.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skibsted.eventplan.model.Event;
import skibsted.eventplan.model.Review;
import skibsted.eventplan.service.IEventService;
import skibsted.eventplan.service.IReviewService;

import java.util.Optional;

@RestController
public class ReviewController {

    private IReviewService reviewService;
    private IEventService eventService;

    public ReviewController(IReviewService reviewService, IEventService eventService) {
        this.reviewService = reviewService;
        this.eventService = eventService;
    }

    @PostMapping("/createReview")
    public ResponseEntity<String> createReview(@RequestBody Review review, @RequestParam Long eventID){
        String msg="";
        Optional<Event> event_ = eventService.findById(eventID);
        if(event_.isPresent())  {
            review.setEvent(event_.get());
            reviewService.save(review);
            msg="Oprettet review :" + review.getEvent();
        }else{
            msg="Fejl i oprettelse af :" + review.getEvent();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }
}
