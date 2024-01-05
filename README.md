## 가상부동산
실제 대한민국 행정 구역을 지도위에 구획하여 일정 크기 블록으로 나누어 토지 분양을 합니다. <br>
블록들은 GPS 좌표 정보 데이터를 기반으로 설계하고, 관리자가 행정 동/읍으로 분양지를 생성합니다. <br>
분양을 시작하면 신청을 받을 수 있고, 신청 마감일에 인원을 추첨하여 당첨/탈락을 결정합니다. <br>
분양받으면 블록의 소유권을 가질 수 있고,  신청 포인트를 반납합니다.
## 
#### 관리자 페이지
* 카테고리 분류
    * 주거지
    * 상업지
    * 국유지
    * 사유지
    * 미분양지

   <br>

* 행정 동/읍 을 구역별 분양지 생성
    * 분양 신청 기간 설정
    * 분양 신청 인원 제한
    * 블록 당 최대/최소 투자금
    * 최대 블록 신청 개수

   <br>

***
- ### 개발 환경
    * ![](https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)![](https://img.shields.io/badge/17-grey?style=for-the-badge)
    * ![](https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white)![](https://img.shields.io/badge/3.2.1-grey?style=for-the-badge)
    * ![](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white)
      ![](https://img.shields.io/badge/Swagger-44cc11?style=for-the-badge&logo=swagger&logoColor=white)
      ![](https://img.shields.io/badge/Debian-A81D33?style=for-the-badge&logo=debian&logoColor=white)
      ![](https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
      ![](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)


<br></br>

- ### 플로우 챠트
  <img src="https://private-user-images.githubusercontent.com/85206794/294124393-8aa108eb-7b56-42ce-b3af-7e741f87e231.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDQ0NDg5NTAsIm5iZiI6MTcwNDQ0ODY1MCwicGF0aCI6Ii84NTIwNjc5NC8yOTQxMjQzOTMtOGFhMTA4ZWItN2I1Ni00MmNlLWIzYWYtN2U3NDFmODdlMjMxLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMDUlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTA1VDA5NTczMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWRjZDEwMmIxNGI3Yzc4YzZkZDQzMTlkYTViYjA0ODJiYjg4OWQ5MjA2MTRlZjNhZTQ0MGI0ZjI0YjI5NjdjZDEmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.RIHncojI4wZy4gQVNEubZ74S8pAkJyfiKNbXgfcDDS0" style="background-color: white;">


<br></br>

- ### ERD
  <img src="https://private-user-images.githubusercontent.com/85206794/294123195-2e2cca78-619a-4558-8095-7ee7d6e6630d.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDQ0NDg5NTAsIm5iZiI6MTcwNDQ0ODY1MCwicGF0aCI6Ii84NTIwNjc5NC8yOTQxMjMxOTUtMmUyY2NhNzgtNjE5YS00NTU4LTgwOTUtN2VlN2Q2ZTY2MzBkLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMDUlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTA1VDA5NTczMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTJiNTk4ZmU1NzIxYjAyNDAyM2UzMjI1MmNiZjRhMTA2ZTZjNjhiZWJhZTZlMjczZjJiYTk4ZjMxMmVjYjdmMzEmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.3ekAyKKwLHypGrloJms4dAwl6FCJ2jo-Q8IWedI3A9A" style="background-color: white;">