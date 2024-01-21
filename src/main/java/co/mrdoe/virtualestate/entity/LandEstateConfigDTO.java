package co.mrdoe.virtualestate.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class LandEstateConfigDTO {

    private LandSaleConfigDAO landSaleVO;
    private List<Integer> dngList;
    private List<StaticBlockCoordsDAO> blockList;

    private String errMsg;
}
