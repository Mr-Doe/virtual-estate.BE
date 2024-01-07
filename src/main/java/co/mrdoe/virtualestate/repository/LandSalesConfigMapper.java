package co.mrdoe.virtualestate.repository;

import co.mrdoe.virtualestate.entity.LandSaleConfigDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LandSalesConfigMapper {

    @Select(
            "SELECT                     \n" +
            "   id, name                \n" +
            "FROM   land_sale           \n" +
            "WHERE  is_activated = 'Y'  \n" +
            "   AND dist_id = #{distId} "
    )List<LandSaleConfigDAO> findLandSalesNameAllByDistId(@Param("distId")int DistId);
}
