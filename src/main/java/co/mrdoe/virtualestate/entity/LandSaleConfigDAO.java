package co.mrdoe.virtualestate.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LandSaleConfigDAO {

    private int id;
    private int dist_id;
    private int center_dng_id;
    private String name;
    private int seed_cell_price;
    private int max_investments;
    private String reg_type;
    private int subsc_type;
    private String subsc_begin;
    private String subsc_end;
    private int subsc_flag;
    private String release_at;
    private String lease_expire;
    private String audit_done;
    private String is_activated;
    private String create_at;

}
