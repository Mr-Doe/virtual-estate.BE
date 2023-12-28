package co.mrdoe.virtualestate.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StaticBoundaryCoordsDAO {

    private int id;
    private int link_id;
    private String name;
    private float z_level;
    private String c_coords;
    private String b_coords;
    private int ln_code;

    private List<List<CoordsVO>> coordsList;

}
