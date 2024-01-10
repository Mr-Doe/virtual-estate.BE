package co.mrdoe.virtualestate.config.Docs;

import co.mrdoe.virtualestate.entity.LandSaleConfigDAO;
import co.mrdoe.virtualestate.entity.StaticBoundaryCoordsDAO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Admin 페이지")
@ApiResponse(content = @Content(schema = @Schema(hidden = true)))
public interface AdminControllerDocs {

    @Operation(summary = "도/시 이름 조회"
            ,description = "<h2>[목록]</h2>" +
                            "<h3>도/시 이름 모두 불러오기</h3>")
    @Schema(implementation = StaticBoundaryCoordsDAO.class)
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
    ResponseEntity<List<LandSaleConfigDAO>> getLandSalesName(@Parameter(description = "구 ID")int distId);

    @Operation(summary = "분양지 만들기 및 설정"
            ,description = "<h2>[설정]</h2>" +
                            "<h3>분양지를 만들기 위한 설정 값들을 받아서 분양지 ID를 되돌려줌</h3>" +
                            "<p>" +
                            "**dist_id** = 행정구 ID <br>" +
                            "**c_dng_id** = 분양지의 중심이 될 행정동 ID <br>" +
                            "**name** = 분양지 이름 <br>" +
                            "**seed_cell_price** = 분양 신청 접수비 <br>" +
                            "**max_investments** = 분양 신청을 받기 위한 투자비 (투지비 등을 고려서 하여 우선순위로 당첨 됨) <br>" +
                            "**reg_type** = {100개 블록 타입 당첨자 수},{100개 블록 타입}, {200개 블록 타입 당첨자 수},{200개 블록 타입} <br>" +
                            "**subsc_type** = 분양지 타입 (1:주거지, 2:상업지, ...) <br>" +
                            "**subsc_begin** = 분양시작 시간 <br>" +
                            "**subsc_end** = 분양마감 시간 <br>" +
                            "**release_at** = 당첨자 추첨 시간 <br>" +
                            "**lease_expire** = 블럭 임대 마감 시간 <br>" +
                            "**salt** = 보안 적용전 임시 인증 비밀번호" +
                            "</p>" +
                            "*값 변경 가능*")
    @RequestBody(
            content = @Content(
                    schema = @Schema(implementation = LandSaleConfigDAO.class),
                    examples = @ExampleObject(value =
                        "{                                              " +
                        "\"dist_id\"            :   1,                  " +
                        "\"c_dng_id\"           :   1,                  " +
                        "\"name\"               :   \"fff\",            " +
                        "\"seed_cell_price\"    :   10,                 " +
                        "\"max_investments\"    :   1000,               " +
                        "\"reg_type\"           :   \"10,100,20,200\",  " +
                        "\"subsc_type\"         :   1,                  " +
                        "\"subsc_begin\"        :   \"1-1-1 1:1:1\",    " +
                        "\"subsc_end\"          :   \"1-1-1 1:1:1\",    " +
                        "\"release_at\"         :   \"1-1-1 1:1:1\",    " +
                        "\"lease_expire\"       :   \"1-1-1 1:1:1\",     " +
                        "\"salt\"               :   \"is this right the password?\"" +
                        "}                                              ")))
    ResponseEntity<String> postLandSalesConfig(LandSaleConfigDAO landDAO);
    @Operation(summary = "분양지 설정 조회"
            ,description = "<h2>[설정]</h2>" +
                            "<h3>분양지 ID로 분양지 설정 된 값 불러오기</h3>")
    ResponseEntity<LandSaleConfigDAO> getLandSalesConfig(@Parameter(description = "분양지 ID") int landId);
    @Operation(summary = "분양지 설정 수정"
            ,description = "<h2>[설정]</h2>" +
                            "<h3>수정된 분양지 설정 값들을 받아서 0, 1, update failed 값을 되돌려줌</h3>" +
                            "<p>" +
                            "**id** = 분양지 ID <br>" +
                            "**name** = 분양지 이름 <br>" +
                            "**seed_cell_price** = 분양 신청 접수비 <br>" +
                            "**max_investments** = 분양 신청을 받기 위한 투자비 (투지비 등을 고려서 하여 우선순위로 당첨 됨) <br>" +
                            "**reg_type** = {100개 블록 타입 당첨자 수},{100개 블록 타입}, {200개 블록 타입 당첨자 수},{200개 블록 타입} <br>" +
                            "**subsc_begin** = 분양시작 시간 <br>" +
                            "**subsc_end** = 분양마감 시간 <br>" +
                            "**release_at** = 당첨자 추첨 시간 <br>" +
                            "**lease_expire** = 블럭 임대 마감 시간 <br>" +
                            "**salt** = 보안 적용전 임시 인증 비밀번호" +
                            "</p>" +
                            "*값 변경 가능*")
    @RequestBody(
            content = @Content(
                    schema = @Schema(implementation = LandSaleConfigDAO.class),
                    examples = @ExampleObject(value =
                    "{                                              " +
                    "\"id\"                 :   0,                  " +
                    "\"name\"               :   \"example\",        " +
                    "\"seed_cell_price\"    :   10,                 " +
                    "\"max_investments\"    :   1000,               " +
                    "\"reg_type\"           :   \"10,100,20,200\",  " +
                    "\"subsc_begin\"        :   \"1-1-1 1:1:1\",    " +
                    "\"subsc_end\"          :   \"1-1-1 1:1:1\",    " +
                    "\"release_at\"         :   \"1-1-1 1:1:1\",    " +
                    "\"lease_expire\"       :   \"1-1-1 1:1:1\",     " +
                    "\"salt\"               :   \"It will be changed@@\"" +
                    "}                          ")))
    ResponseEntity<String> putLandSalesConfig(LandSaleConfigDAO landDAO);
    @Operation(summary = "분양지 삭제"
            ,description = "<h2>설정</h2>" +
                            "<h3>분양지 설정 삭제</h3>" +
                            "<p>" +
                            "**id** = 분양지 ID <br>" +
                            "**salt** = 보안 적용전 임시 인증 비밀번호" +
                            "</p>" +
                            "*값 변경 가능*")
    @RequestBody(
            content = @Content(
                    schema = @Schema(implementation = LandSaleConfigDAO.class),
                    examples = @ExampleObject(value =
                            "{                                          " +
                            "\"id\"     :   0,                          " +
                            "\"salt\"   :   \"It will be deleted!!\"    " +
                            "}                                          ")))
    ResponseEntity<String> deleteLandSalesConfig(LandSaleConfigDAO landDao);

}
