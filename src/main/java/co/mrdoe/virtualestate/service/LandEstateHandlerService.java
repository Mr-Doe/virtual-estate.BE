package co.mrdoe.virtualestate.service;

import co.mrdoe.virtualestate.entity.LandEstateConfigDTO;
import co.mrdoe.virtualestate.repository.LandSalesRefDngMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LandEstateHandlerService {

    private final LandSalesConfigService landService;
    private final StaticBlockCoordsService blockService;
    private final LandSalesRefDngMapper refMapper;

    @Autowired
    public LandEstateHandlerService(LandSalesConfigService landService
                                    ,StaticBlockCoordsService blockService
                                    ,LandSalesRefDngMapper refMapper ) {
        this.landService = landService;
        this.blockService = blockService;
        this.refMapper = refMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public String insertLandAndBlockConfig(LandEstateConfigDTO dto) throws Exception {
        int saleId = landService.insertLandSalesConfig(dto.getLandSaleVO());
        if(refMapper.saveLandSalesReferDng(saleId, dto.getDngList()) == 0)
            throw new Exception("save failed :: Ref.");
        if(blockService.insertStaticBlockCoords(dto.getBlockList()) == 0)
            throw new Exception("save failed :: block");

        return String.valueOf(saleId);
    }
}
