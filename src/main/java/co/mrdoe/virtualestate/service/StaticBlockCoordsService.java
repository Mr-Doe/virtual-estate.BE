package co.mrdoe.virtualestate.service;

import co.mrdoe.virtualestate.entity.CoordsVO;
import co.mrdoe.virtualestate.entity.StaticBlockCoordsDAO;
import co.mrdoe.virtualestate.repository.StaticBlockCoordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class StaticBlockCoordsService {

    private final String[] TWENTY_CODES = {"2","3","4","5","6","7","8","9","C","F","G","H","J","M","P","Q","R","V","W","X"};
    private final StaticBlockCoordsMapper blockMapper;

    @Autowired
    private StaticBlockCoordsService(StaticBlockCoordsMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    public List<StaticBlockCoordsDAO> selectStaticBlockCoordsBySaleId(int saleId) {
        return blockMapper.findBlockBySaleId(saleId);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insertStaticBlockCoords(List<StaticBlockCoordsDAO> blockList) throws Exception {
        int isPassed = 0;
        int batchSize = 1000;

        blockList.forEach(vo -> {
            try {
                VALID_PLUSCODE(vo);
                VALID_ID(vo);
                VALID_COORDS(vo);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });

        while (blockList.size() >= batchSize) {
            isPassed = blockMapper.saveStaticBlockCoords(blockList.subList(0, batchSize));
            if(isPassed == 0) throw new Exception("Block-Coords INSERT failed!!");
            blockList.subList(0, batchSize).clear();
        }
        if(!blockList.isEmpty()) {
            isPassed = blockMapper.saveStaticBlockCoords(blockList.subList(0, batchSize));
            if(isPassed == 0) throw new Exception("Block-Coords INSERT failed!!");
        }

        return isPassed;
    }

    @Transactional(rollbackFor = Exception.class)
    public int updateStaticBlockCoords(List<StaticBlockCoordsDAO> blockList) throws Exception {
        int isPassed = 0;
        int batchSize = 1000;

        blockList.forEach(vo -> {
            try {
                VALID_ID(vo);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });

        while (blockList.size() >= batchSize) {
            isPassed = blockMapper.updateStaticBlockCoords(blockList.subList(0, batchSize));
            if(isPassed == 0) throw new Exception("Block-Coords UPDATE failed!!");
            blockList.subList(0, batchSize).clear();
        }
        if(!blockList.isEmpty()) {
            isPassed = blockMapper.updateStaticBlockCoords(blockList.subList(0, batchSize));
            if(isPassed == 0) throw new Exception("Block-Coords UPDATE failed!!");
        }

        return isPassed;
    }

    private void VALID_PLUSCODE(StaticBlockCoordsDAO DAO) throws Exception {
        String plusCode = convertFromCoordsToPlusCode(
                CoordsVO.builder()
                        .lat(DAO.getCoords_y())
                        .lng(DAO.getCoords_x())
                        .build()
        );
        if(DAO.getPlus_code().isEmpty()) {
            DAO.setPlus_code(plusCode);
        }else if(!DAO.getPlus_code().equals(plusCode)) {
            throw new Exception("PLUS_CODE is different");
        }
    }
    private void VALID_ID(StaticBlockCoordsDAO DAO) throws Exception {
        String id = Integer.toHexString( (int)DAO.getCoords_y() * 1000000 )
                + Integer.toHexString( (int)DAO.getCoords_x() * 1000000 );
        if(DAO.getId().isEmpty()) {
            DAO.setId(id.toUpperCase());
        }else if(DAO.getId().equals(id.toUpperCase())) {
            throw new Exception("HEX_ID is different");
        }
    }
    private void VALID_COORDS(StaticBlockCoordsDAO DAO) throws Exception {
        CoordsVO plusCodeToVO = converttFromPlusCodeToCoords(DAO.getPlus_code());
        CoordsVO idToVO = CoordsVO.builder()
                .lat((float)Integer.parseInt(DAO.getId().substring(0, 8), 16) / 1000000)
                .lng((float)Integer.parseInt(DAO.getId().substring(8), 16) / 1000000)
                .build();

        if(DAO.getCoords_y() != plusCodeToVO.getLat() && DAO.getCoords_x() != plusCodeToVO.getLng())
            throw new Exception("COORDS & PLUS_CODE are different");
        if(DAO.getCoords_y() != idToVO.getLat() && DAO.getCoords_x() != idToVO.getLng())
            throw new Exception("COORDS & HEX_ID are different");
    }
    private CoordsVO converttFromPlusCodeToCoords(String plusCode) {
        String[] c = plusCode.split("");
        String[] lat = {c[0], c[2], c[4], c[6], c[9]};
        String[] lng = {c[1], c[3], c[5], c[7], c[10]};

        double y = 0;
        double x = 0;

        for(int i = 0; i <= 4; i++) {
            y += Arrays.asList(TWENTY_CODES).indexOf(lat[i]) * Math.pow(20, 4-i);
            x += Arrays.asList(TWENTY_CODES).indexOf(lng[i]) * Math.pow(20, 4-i);
        }

        return CoordsVO.builder()
                .lat( x / Math.pow(20, 3) -90 +0.000063 )
                .lng( y / Math.pow(20, 3) -180 +0.000063 )
                .build();
    }
    private String convertFromCoordsToPlusCode(CoordsVO vo) {
        String[] lat = null;
        String[] lng = null;

        double y = ( vo.getLat() + 90 ) * Math.pow(20, 4);
        double x = ( vo.getLng() + 180 ) * Math.pow(20, 4);

        for(int i = 4; i >= 0; i--) {
            y = y / 20;
            x = x / 20;
            lat[i] = TWENTY_CODES[ (int)(Math.floor(y) % 20) ];
            lng[i] = TWENTY_CODES[ (int)(Math.floor(x) % 20) ];
        }

        String plusCode = null;
        for(int i = 0; i <= 4; i++) {
            plusCode += lat[i];
            plusCode += lng[i];
        }

        return plusCode.substring(0, 8) + "+" + plusCode.substring(8);
    }

}




