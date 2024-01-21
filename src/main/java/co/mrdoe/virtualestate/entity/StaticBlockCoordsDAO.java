package co.mrdoe.virtualestate.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StaticBlockCoordsDAO {

    private String id;
    private int sale_id;
    private int dng_id;
    private String owner;
    private int block_type;
    private String plus_code;
    private double coords_y;
    private double coords_x;
    private String expire_at;

}
