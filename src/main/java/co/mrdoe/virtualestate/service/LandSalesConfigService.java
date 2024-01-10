package co.mrdoe.virtualestate.service;

import co.mrdoe.virtualestate.entity.LandSaleConfigDAO;
import co.mrdoe.virtualestate.repository.LandSalesConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LandSalesConfigService {

    public final LandSalesConfigMapper landMapper;

    @Autowired
    public LandSalesConfigService(LandSalesConfigMapper mapper) {
        this.landMapper = mapper;
    }

    public List<LandSaleConfigDAO> selectLandSalesNameByDistId(int distId) {
        return landMapper.findLandSalesNameAllByDistId(distId);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertLandSalesConfig(LandSaleConfigDAO landDAO) throws Exception {
        landMapper.saveLandSalesConfig(landDAO);
        if(landDAO.getSalt().equals("is this right the password?") && landDAO.getId() < 1)
            throw new Exception("save failed!!");
        return landDAO.getId();
    }
    public LandSaleConfigDAO selectLandSalesConfig(int landId) {
        return landMapper.findLandSalesConfigByLandId(landId);
    }
    @Transactional(rollbackFor = Exception.class)
    public int updateLandSalesConfig(LandSaleConfigDAO landDAO) throws Exception {
        if(landDAO.getSalt().equals("It will be changed@@")) {
            return landMapper.updateLandSaleConfig(landDAO);
        }else {
            throw new Exception("the password is wrong");
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public int deleteLandSalesConfig(LandSaleConfigDAO landDAO) throws Exception {
        if(landDAO.getSalt().equals("It will be deleted!!")) {
            return landMapper.deleteLandSaleConfig(landDAO.getId());
        }else {
            throw new Exception("the password is wrong");
        }
    }

}
