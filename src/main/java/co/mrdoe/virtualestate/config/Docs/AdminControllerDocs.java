package co.mrdoe.virtualestate.config.Docs;

import co.mrdoe.virtualestate.entity.LandSaleConfigDAO;
import co.mrdoe.virtualestate.entity.StaticBoundaryCoordsDAO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Admin 페이지")
@ApiResponse(content = @Content(schema = @Schema(hidden = true)))
public interface AdminControllerDocs {

    @Operation(summary = "도/시 이름 조회"
            ,description = "<h2>[목록]</h2>" +
                            "<h3>도/시 이름 모두 불러오기</h3>")
    ResponseEntity<List<StaticBoundaryCoordsDAO>> getCityNameAll();

    @Operation(summary = "시/구 지도 조회"
            ,description = "<h2>[지도]</h2>" +
                            "<h3>도/시 ID로 도/시에 속한 시/구의 GSP 좌표 불러오기</h3>" +
                            "<p>예) 서울=1, 부산=2, ...</p>" +
                            "*주의 : 좌표 데이터 용량 큼*")
    ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistCoords(@Parameter(description = "시 ID") int cityId);

    @Operation(summary = "시/구 이름 조회"
            ,description = "<h2>[목록]</h2>" +
                            "<h3>도/시 ID로 도/시에 속한 시/구의 이름 불러오기</h3>" +
                            "<p>예) 서울=1, 부산=2, ...</p>")
    ResponseEntity<List<StaticBoundaryCoordsDAO>> getDistName(@Parameter(description = "시 ID")int cityId);

    @Operation(summary = "읍/동 지도 조회"
            ,description = "<h2>[지도]</h2>" +
                            "<h3>시/구 ID로 시/구에 속한 읍/동 GPS 좌표 불러오기</h3>" +
                            "<p>예) 종로구=1, 중구=2 ...</p>" +
                            "*주의 : 좌표 데이터 용량 큼*")
    ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngCoords(@Parameter(description = "구 ID")int distId);

    @Operation(summary = "읍/동 이름 조회"
            ,description = "<h2>[목록]</h2>" +
                            "<h3>시/구 ID로 시/구에 속한 읍/동의 이름 불러오기</h3>" +
                            "<p>예) 종로구=1, 중구=2 ...</p>")
    ResponseEntity<List<StaticBoundaryCoordsDAO>> getDngName(@Parameter(description = "구 ID")int distId);

    @Operation(summary = "분양지 이름 조회"
            ,description = "<h2>[목록]</h2>" +
                            "<h3>시/구 ID로 시/구에 속한 분양지 이름 불러오기</h3>")
    ResponseEntity<List<LandSaleConfigDAO>> getLandSalesNAme(@PathVariable("distId")int distId);

}
