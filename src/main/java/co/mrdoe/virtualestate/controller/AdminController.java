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


    @GetMapping("/city-init")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getCityNameAll() {
        return new ResponseEntity<>(staticService.getCityNameAll(), HttpStatus.OK);
    }
    @GetMapping("/dist-a/coords-{cityId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistCoords(@PathVariable("cityId")int cityId) {
        return new ResponseEntity<>(staticService.getDistCoordsAllByCityId(cityId), HttpStatus.OK);
    }
    @GetMapping("/dist-a/name-{cityId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistName(@PathVariable("cityId")int cityId) {
        return new ResponseEntity<>(staticService.getDistNameAllByCityId(cityId), HttpStatus.OK);
    }
    @GetMapping("/dng-a/coords-{distId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngCoords(@PathVariable("distId")int distId) {
        return new ResponseEntity<>(staticService.getDngCoordsAllByDistId(distId), HttpStatus.OK);
    }
    @GetMapping("/dng-a/name-{distId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngName(@PathVariable("distId")int distId) {
        return new ResponseEntity<>(staticService.getDngNameAllByDistId(distId), HttpStatus.OK);
    }
//    @GetMapping("/sale-a/cell-{dngId}")

}
