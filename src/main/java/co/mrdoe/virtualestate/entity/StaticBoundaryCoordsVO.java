package co.mrdoe.virtualestate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StaticBoundaryCoordsVO {

    private int id;
    private int link_id;
    private String name;
    private float z_level;
    private String c_coords;
    private String b_coords;
    private int ln_code;

    private String[] coordsList;

    private StaticBoundaryCoordsVO() {
        this.coordsList = this.b_coords.split(";");
    }
}
