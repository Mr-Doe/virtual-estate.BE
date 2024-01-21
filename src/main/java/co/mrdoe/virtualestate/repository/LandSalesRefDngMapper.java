package co.mrdoe.virtualestate.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LandSalesRefDngMapper {

    @Insert(
            "<script>" +
            "   INSERT INTO land_sale_ref_dng(sale_id, dng_id) VALUES" +
            "   <foreach collect='list' item='ref' separator=','>" +
            "       (#{saleId}, #{ref.dng_id})" +
            "   </foreach>" +
            "</script>"
    )int saveLandSalesReferDng(@Param("sale_id")int saleId, @Param("list")List<Integer> list);
}
