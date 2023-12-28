package co.mrdoe.virtualestate.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class CoordsVO {

    private double lat;
    private double lng;

}
