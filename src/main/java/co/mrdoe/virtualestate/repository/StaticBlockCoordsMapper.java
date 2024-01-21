package co.mrdoe.virtualestate.repository;

import co.mrdoe.virtualestate.entity.StaticBlockCoordsDAO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaticBlockCoordsMapper {

    @Select(
            "SELECT                                 \n" +
            "   block.id                            \n" +
            "   ,block.dng_id                       \n" +
            "   ,block.owner                        \n" +
            "   ,block.block_type                   \n" +
            "   ,block.plus_code                    \n" +
            "   ,block.coords_y                     \n" +
            "   ,block.coords_x                     \n" +
            "   ,block.expire_at                    \n" +
            "FROM       static_block_coords `block` \n" +
            "   JOIN    land_sale_ref_dng ref       \n" +
            "       ON  ref.dng_id = block.dng_id   \n" +
            "WHERE      ref.sale_id = #{saleId}     "
    )
    List<StaticBlockCoordsDAO>findBlockBySaleId(@Param("saleId")int saleId);

    @Insert({
            "<script>" +
            "   INSERT INTO static_block_coords(id, dng_id, block_type, plus_code, coords_y, coords_x)              \n" +
            "   VALUES                                                                                              \n" +
            "      <foreach collection='blockList' item='vo' separator=','>                                         \n" +
            "          (#{vo.id}, #{vo.dng_id}, #{vo.block_type}, #{vo.plus_code}, #{vo.coords_y}, #{vo.coords_x})  \n" +
            "      </foreach>                                                                                       \n" +
            "   ON DUPLICATE KEY UPDATE                                                                             \n" +
            "      block_type = IF(block_type = 4, blcok_type, VALUES(block_type)                                   \n" +
            "</script>"
    })int saveStaticBlockCoords(@Param("blockList")List<StaticBlockCoordsDAO> blockList);

    @Update({
            "<script>" +
            "   <foreach collection='blockList' item='vo' separator=';'>                \n" +
            "      UPDATE static_block_coords                                           \n" +
            "      <set>                                                                \n" +
            "           block_type = IF(owner IS NULL, #{vo.block_type}, block_type)    \n" +
            "      </set>                                                               \n" +
            "      WHERE id = #{vo.id}                                                  \n" +
            "   </foreach>                                                              \n" +
            "</script>"
    })int updateStaticBlockCoords(@Param("blockList")List<StaticBlockCoordsDAO> blockList);

    @Update({
            "<script>" +
            "   <foreach collection='blockList' item='vo' separator=';'>    \n" +
            "       UPDATE static_block_coords                              \n" +
            "       <set>                                                   \n" +
            "           sale_id = 0                                         \n" +
            "           ,owner = null                                       \n" +
            "           ,block_type = IF(block_type = 4, 0, block_type)     \n" +
            "           ,expire_at = null                                   \n" +
            "       </set>                                                  \n" +
            "       WHERE id = #{vo.id}                                     \n" +
            "   </foreach>                                                  \n" +
            "</script>"
    })int deleteStaticBlockCoords(@Param("blockList")List<StaticBlockCoordsDAO> blockList);

}
