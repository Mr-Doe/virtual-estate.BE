package co.mrdoe.virtualestate.repository;

import co.mrdoe.virtualestate.entity.LandSaleConfigDAO;
import org.apache.ibatis.annotations.*;

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

    @Insert(
            "INSERT INTO land_sale (            \n" +
            "   dist_id                         \n" +
            "   ,c_dng_id                       \n" +
            "   ,`name`                         \n" +
            "   ,seed_cell_price                \n" +
            "   ,max_investments                \n" +
            "   ,reg_type                       \n" +
            "   ,subsc_type                     \n" +
            "   ,subsc_begin                    \n" +
            "   ,subsc_end                      \n" +
            "   ,subsc_stat                     \n" +
            "   ,release_at                     \n" +
            "   ,lease_expire                   \n" +
            ")VALUES (                          \n" +
            "   #{landDAO.dist_id}              \n" +
            "   ,#{landDAO.c_dng_id}            \n" +
            "   ,#{landDAO.name}                \n" +
            "   ,#{landDAO.seed_cell_price}     \n" +
            "   ,#{landDAO.max_investments}     \n" +
            "   ,#{landDAO.reg_type}            \n" +
            "   ,#{landDAO.subsc_type}          \n" +
            "   ,#{landDAO.subsc_begin}         \n" +
            "   ,#{landDAO.subsc_end}           \n" +
            "   ,#{landDAO.subsc_type}          \n" +
            "   ,#{landDAO.release_at}          \n" +
            "   ,#{landDAO.lease_expire}        \n" +
            ")                                  "
    )@Options(useGeneratedKeys = true, keyProperty = "id")
    void saveLandSalesConfig(@Param("landDAO")LandSaleConfigDAO landDAO);
    @Select(
            "SELECT                             \n" +
            "   land.id                         \n" +
            "   ,land.dist_id                   \n" +
            "   ,land.name                      \n" +
            "   ,land.seed_cell_price           \n" +
            "   ,land.max_investments           \n" +
            "   ,land.reg_type                  \n" +
            "   ,land.subsc_type                \n" +
            "   ,land.subsc_begin               \n" +
            "   ,land.subsc_end                 \n" +
            "   ,land.release_at                \n" +
            "   ,land.lease_expire              \n" +
            "   ,dng.name AS c_dng_name         \n" +
            "   ,dng.c_coords AS c_dng_coords   \n" +
            "FROM land_sale land                \n" +
            "   JOIN static_dng_coords dng      \n" +
            "       ON land.c_dng_id = dng.id   \n" +
            "WHERE land.is_activated = 'Y'      \n" +
            "   AND land.id = #{landId}         "
    )LandSaleConfigDAO findLandSalesConfigByLandId(@Param("landId")int landId);
    @Update(
            "UPDATE land_sale SET                               \n" +
            "   `name` = #{landDAO.name}                        \n" +
            "   ,seed_cell_price = #{landDAO.seed_cell_price}   \n" +
            "   ,max_investments = #{landDAO.max_investments}   \n" +
            "   ,reg_type = #{landDAO.reg_type}                 \n" +
            "   ,subsc_begin = #{landDAO.subsc_begin}           \n" +
            "   ,subsc_end = #{landDAO.subsc_end}               \n" +
            "   ,release_at = #{landDAO.release_at}             \n" +
            "   ,lease_expire = #{landDAO.lease_expire}         \n" +
            "WHERE  is_activated = 'Y'                          \n" +
            "   AND id = #{landDAO.id}                          "
    )int updateLandSaleConfig(@Param("landDAO")LandSaleConfigDAO landDAO);
    @Delete("DELETE FROM land_sale WHERE id = #{landId}")
    int deleteLandSaleConfig(@Param("landId")int landId);

}
