package skibsted.eventplan.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import skibsted.eventplan.model.Band;
import skibsted.eventplan.model.User;
import skibsted.eventplan.service.IBandService;

import java.util.Set;

@RestController
public class BandController {

    private IBandService bandService;

    public BandController(IBandService bandService) {this.bandService = bandService;}

    @PostMapping("/createBand")
    public ResponseEntity<String> createBand(@RequestBody Band band) {
        String msg="";
        if(bandService.save(band)!=null)  {
            msg="Oprettet band: " + band.getName();
        }else {
            msg="fejl i oprettelsen af " + band.getName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/getBands")
    public ResponseEntity<Set<Band>> getBands() {
        return new ResponseEntity<>(bandService.findAll(), HttpStatus.OK);
    }
}

