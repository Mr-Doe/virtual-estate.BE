package co.mrdoe.virtualestate.controller;

import co.mrdoe.virtualestate.entity.StaticBoundaryCoordsDAO;
import co.mrdoe.virtualestate.service.StaticBoundaryCoordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final StaticBoundaryCoordsService staticService;

    @Autowired
    public AdminController(StaticBoundaryCoordsService service) {
        this.staticService = service;
    }


    @GetMapping("/city-a")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getCityAll() {
        return new ResponseEntity<>(staticService.getCityAll(), HttpStatus.OK);
    }
    @GetMapping("/dist-a/{id}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistAllByCityId(@PathVariable("id")int cityId) {
        return new ResponseEntity<>(staticService.getDistAllByCityId(cityId), HttpStatus.OK);
    }
    @GetMapping("/dng-a/{id}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngAllByDistId(@PathVariable("id")int distId) {
        return new ResponseEntity<>(staticService.getDngAllByDistId(distId), HttpStatus.OK);
    }
    @GetMapping("/dng-{id}")
    public ResponseEntity<StaticBoundaryCoordsDAO> getDngByDngId(@PathVariable("id")int dngId) {
        return new ResponseEntity<>(staticService.getDngByDngId(dngId), HttpStatus.OK);
    }

}
