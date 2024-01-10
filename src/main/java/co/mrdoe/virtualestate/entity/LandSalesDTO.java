package co.mrdoe.virtualestate.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class LandSalesDTO {

    private LandSaleConfigDAO landDAO;
    private String errMsg;
}
