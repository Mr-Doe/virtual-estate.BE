package co.mrdoe.virtualestate.repository;

import co.mrdoe.virtualestate.entity.StaticBoundaryCoordsDAO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StaticBoundaryCoordsMapper {

    @Select(
            "SELECT                     \n" +
            "   id, `name`              \n" +
            "FROM   static_city_coords  \n" +
            "WHERE  is_activated = 'Y'  "
    )List<StaticBoundaryCoordsDAO> findCityNameAll();

    @Select(
            "SELECT                             \n" +
            "   id, z_level, c_coords, b_coords \n" +
            "FROM   static_dist_coords          \n" +
            "WHERE  is_activated = 'Y'          \n" +
            "   AND city_id = #{id}             "
    )List<StaticBoundaryCoordsDAO> findDistCoordsAllByCityId(@Param("id")int id);

    @Select(
            "SELECT                     \n" +
            "   id, `name`              \n" +
            "FROM   static_dist_coords  \n" +
            "WHERE  is_activated = 'Y'  \n" +
            "   AND city_id = #{id}     "
    )List<StaticBoundaryCoordsDAO> findDistNameAllByCityId(@Param("id")int id);

    @Select(
            "SELECT                             \n" +
            "   id, z_level, c_coords, b_coords \n" +
            "FROM   static_dng_coords           \n" +
            "WHERE  is_activated = 'Y'          \n" +
            "   AND dist_id = #{id}             "
    )List<StaticBoundaryCoordsDAO> findDngCoordsAllByDistId(@Param("id")int id);

    @Select(
            "SELECT                     \n" +
            "   id, `name`              \n" +
            "FROM   static_dng_coords   \n" +
            "WHERE  is_activated = 'Y'  \n" +
            "   AND dist_id = #{id}     "
    )List<StaticBoundaryCoordsDAO> findDngNameAllByDistId(@Param("id")int id);

    @Select(
            "SELECT                                     \n" +
            "   id, z_level, c_coords, b_coords \n" +
            "FROM   static_dng_coords                   \n" +
            "WHERE  is_activated = 'Y'                  \n" +
            "   AND id = #{id}                          "
    )
    StaticBoundaryCoordsDAO findDngByDngId(@Param("id")int id);

}
