package skibsted.eventplan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skibsted.eventplan.model.User;
import skibsted.eventplan.model.Venue;
import skibsted.eventplan.service.IUserService;
import skibsted.eventplan.service.IVenueservice;

import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {

    private IUserService userService;
    private IVenueservice venueService;

    public UserController(IUserService userService, IVenueservice venueservice) {
        this.userService = userService;
        this.venueService = venueService;
    }

    @PostMapping("/createLike")
    public ResponseEntity<String> createLike(@RequestParam Long userID,
                                             @RequestParam Long venueID){
        Optional<User> user_ = userService.findById(userID);
        Optional<Venue> venue_ = venueService.findById(venueID);
        if(user_.isPresent() && venue_.isPresent()){
            user_.get().getVenuesLiked().add(venue_.get());
            userService.save(user_.get());
            return new ResponseEntity<>("ok at gemme user: " + userID +
                    " med like venue " + venueID, HttpStatus.OK);
        }
        return new ResponseEntity<>("fejl at oprette like", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        String msg="";
        if(userService.save(user)!=null)  {
            msg="Oprettet bruger: " + user.getName();
        }else {
            msg="fejl i oprettelsen af " + user.getName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<Set<User>> getUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }




}
