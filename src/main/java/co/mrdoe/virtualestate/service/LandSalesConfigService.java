package co.mrdoe.virtualestate.service;

import co.mrdoe.virtualestate.entity.LandSaleConfigDAO;
import co.mrdoe.virtualestate.repository.LandSalesConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandSalesConfigService {

    public final LandSalesConfigMapper landMapper;

    @Autowired
    public LandSalesConfigService(LandSalesConfigMapper mapper) {
        this.landMapper = mapper;
    }

    public List<LandSaleConfigDAO> getLandSalesNameByDistId(int distId) {
        return landMapper.findLandSalesNameAllByDistId(distId);
    }
}
