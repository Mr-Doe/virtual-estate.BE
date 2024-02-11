package co.mrdoe.virtualestate.controller;

import co.mrdoe.virtualestate.config.Docs.AdminControllerDocs;
import co.mrdoe.virtualestate.entity.LandEstateConfigDTO;
import co.mrdoe.virtualestate.entity.LandSaleConfigDAO;
import co.mrdoe.virtualestate.entity.StaticBlockCoordsDAO;
import co.mrdoe.virtualestate.entity.StaticBoundaryCoordsDAO;
import co.mrdoe.virtualestate.service.LandEstateHandlerService;
import co.mrdoe.virtualestate.service.LandSalesConfigService;
import co.mrdoe.virtualestate.service.StaticBlockCoordsService;
import co.mrdoe.virtualestate.service.StaticBoundaryCoordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/admin")
public class AdminController implements AdminControllerDocs {

    private final StaticBoundaryCoordsService staticService;
    private final LandSalesConfigService landService;
    private final LandEstateHandlerService dtoService;
    private final StaticBlockCoordsService blockService;

    @Autowired
    public AdminController(StaticBoundaryCoordsService staticService
                           ,LandSalesConfigService landService
                           ,LandEstateHandlerService dtoService
                           ,StaticBlockCoordsService blockService
    ) {
        this.staticService = staticService;
        this.landService = landService;
        this.dtoService = dtoService;
        this.blockService = blockService;
    }

    @GetMapping("/map/dist-{cityId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistCoords(@PathVariable("cityId")int cityId) {
        return ResponseEntity.ok(staticService.selectDistCoordsAllByCityId(cityId));
    }
    @GetMapping("/map/dng-{distId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngCoords(@PathVariable("distId")int distId) {
        return ResponseEntity.ok(staticService.selectDngCoordsAllByDistId(distId));
    }
    @PutMapping("/map/block")
    public ResponseEntity<String> putBlockCoords(@RequestBody List<StaticBlockCoordsDAO> blockList) {
        /**
         * TODO Swagger 작성.
         */
        try {
            return ResponseEntity.ok(String.valueOf( blockService.updateStaticBlockCoords(blockList) ));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Update Failed!!");
        }
    }


    @GetMapping("/list/city")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getCityNameAll() {
        return ResponseEntity.ok(staticService.selectCityNameAll());
    }
    @GetMapping("/list/dist-{cityId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistName(@PathVariable("cityId")int cityId) {
        return ResponseEntity.ok(staticService.selectDistNameAllByCityId(cityId));
    }
    @GetMapping("/list/dng-{distId}")
    public ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngName(@PathVariable("distId")int distId) {
        return ResponseEntity.ok(staticService.selectDngNameAllByDistId(distId));
    }

    @GetMapping("/list/land-{distId}")
    public ResponseEntity<List<LandSaleConfigDAO>> getLandSalesName(@PathVariable("distId")int distId) {
        return ResponseEntity.ok(landService.selectLandSalesNameByDistId(distId));
    }

    @PostMapping("/conf/land-sale")
    public ResponseEntity<String> postLandSalesConfig(@RequestBody LandEstateConfigDTO landDTO) {
        /**
         * TODO Swagger 설명, 샘플 Object 재작성.
         */
        try {
            return ResponseEntity.ok(dtoService.insertLandAndBlockConfig(landDTO));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Post Failed!!");
        }
    }
    @GetMapping("/conf/land-sale-{landId}")
    public ResponseEntity<LandSaleConfigDAO> getLandSalesConfig(@PathVariable("landId")int landId) {
        return ResponseEntity.ok(landService.selectLandSalesConfig(landId));
    }
    @PutMapping("/conf/land-sale")
    public ResponseEntity<String> putLandSalesConfig(@RequestBody LandSaleConfigDAO landDAO) {
        try {
            return ResponseEntity.ok(String.valueOf(landService.updateLandSalesConfig(landDAO)));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Update Failed!!");
        }
    }
    @DeleteMapping("conf/land-sale")
    public ResponseEntity<String> deleteLandSalesConfig(@RequestBody LandSaleConfigDAO landDAO) {
        try {
            return ResponseEntity.ok(String.valueOf(landService.deleteLandSalesConfig(landDAO)));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Remove Failed!!");
        }
    }
}
