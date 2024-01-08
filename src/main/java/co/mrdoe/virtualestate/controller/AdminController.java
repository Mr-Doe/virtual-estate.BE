package co.mrdoe.virtualestate.controller;

import co.mrdoe.virtualestate.config.Docs.AdminControllerDocs;
import co.mrdoe.virtualestate.entity.LandSaleConfigDAO;
import co.mrdoe.virtualestate.entity.StaticBoundaryCoordsDAO;
import co.mrdoe.virtualestate.service.LandSalesConfigService;
import co.mrdoe.virtualestate.service.StaticBoundaryCoordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController implements AdminControllerDocs {

    private final StaticBoundaryCoordsService staticService;
    private final LandSalesConfigService landService;

    @Autowired
    public AdminController(StaticBoundaryCoordsService staticService, LandSalesConfigService landService) {
        this.staticService = staticService;
        this.landService = landService;
    }

    @GetMapping("/list/city")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getCityNameAll() {
        return new ResponseEntity<>(staticService.getCityNameAll(), HttpStatus.OK);
    }
    @GetMapping("/map/dist-{cityId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistCoords(@PathVariable("cityId")int cityId) {
        return new ResponseEntity<>(staticService.getDistCoordsAllByCityId(cityId), HttpStatus.OK);
    }
    @GetMapping("/list/dist-{cityId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistName(@PathVariable("cityId")int cityId) {
        return new ResponseEntity<>(staticService.getDistNameAllByCityId(cityId), HttpStatus.OK);
    }
    @GetMapping("/map/dng-{distId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngCoords(@PathVariable("distId")int distId) {
        return new ResponseEntity<>(staticService.getDngCoordsAllByDistId(distId), HttpStatus.OK);
    }
    @GetMapping("/list/dng-{distId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngName(@PathVariable("distId")int distId) {
        return new ResponseEntity<>(staticService.getDngNameAllByDistId(distId), HttpStatus.OK);
    }

    @GetMapping("/list/land-{distId}")
    public ResponseEntity<List<LandSaleConfigDAO>> getLandSalesNAme(@PathVariable("distId")int distId) {
        return new ResponseEntity<>(landService.getLandSalesNameByDistId(distId), HttpStatus.OK);
    }

}
