package co.mrdoe.virtualestate.service;

import co.mrdoe.virtualestate.entity.CoordsVO;
import co.mrdoe.virtualestate.entity.StaticBoundaryCoordsDAO;
import co.mrdoe.virtualestate.repository.StaticBoundaryCoordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaticBoundaryCoordsService {

    public final StaticBoundaryCoordsMapper staticMapper;

    @Autowired
    public StaticBoundaryCoordsService(StaticBoundaryCoordsMapper mapper) {
        this.staticMapper = mapper;
    }

    public List<StaticBoundaryCoordsDAO> selectCityNameAll() {
        return staticMapper.findCityNameAll();
    }
    public List<StaticBoundaryCoordsDAO> selectDistCoordsAllByCityId(int cityId) {
        List<StaticBoundaryCoordsDAO> result = staticMapper.findDistCoordsAllByCityId(cityId);
        for(StaticBoundaryCoordsDAO vo : result) {
            vo.setCoordsList(boundaryCoordsConverter(vo.getB_coords()));
            vo.setB_coords(null);
        }
        return result;
    }

    public List<StaticBoundaryCoordsDAO> selectDistNameAllByCityId(int cityId) {
        return staticMapper.findDistNameAllByCityId(cityId);
    }
    public List<StaticBoundaryCoordsDAO> selectDngCoordsAllByDistId(int distId) {
        List<StaticBoundaryCoordsDAO> result = staticMapper.findDngCoordsAllByDistId(distId);
        for(StaticBoundaryCoordsDAO vo : result) {
            vo.setCoordsList(boundaryCoordsConverter(vo.getB_coords()));
            vo.setB_coords(null);
        }
        return result;
    }

    public List<StaticBoundaryCoordsDAO> selectDngNameAllByDistId(int distId) {
        return staticMapper.findDngNameAllByDistId(distId);
    }
    public StaticBoundaryCoordsDAO getDngByDngId(int dngId) {
        StaticBoundaryCoordsDAO result = staticMapper.findDngByDngId(dngId);
        result.setCoordsList(boundaryCoordsConverter(result.getB_coords()));
        result.setB_coords(null);
        return result;
    }

    private List<List<CoordsVO>> boundaryCoordsConverter(String bCoords) {
        List<List<CoordsVO>> result = new ArrayList<>();

        for(String outer : bCoords.split("/")) {
            List<CoordsVO> innerList = new ArrayList<>();
            for(String inner : outer.split(";")) {
                String[] coords = inner.split(",");
                innerList.add(
                        CoordsVO.builder()
                                .lat(Double.valueOf(coords[0]))
                                .lng(Double.valueOf(coords[1]))
                                .build()
                );
            }result.add(innerList);
        }
        return result;
    }
}
