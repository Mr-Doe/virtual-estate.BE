## 가상부동산
실제 대한민국 행정 구역을 지도위에 구획하여 일정 크기 블록을 GPS 좌표 정보 데이터를 기반하여 토지 분양 설정/관리. <br />
분양지의 마감일에 분양 당첨 인원 추첨, 미분양 된 인원은 포인트 환불.
## 
   #### 관리자 페이지
   * 카테고리 분류
     * 주거지
     * 상업지
     * 국유지
     * 사유지
     * 미분양지
     
   <br />

   * 행정 동/읍 을 구역별 분양지 생성
     * 분양 신청 기간 설정
     * 분양 신청 인원 제한
     * 블록 당 최대/최소 투자금
     * 최대 블록 신청 개수
   
   <br />

***
   ### 개발 환경
   * ![](https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)![](https://img.shields.io/badge/17-grey?style=for-the-badge)
   * ![](https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white)![](https://img.shields.io/badge/3.2.1-grey?style=for-the-badge)
   * ![](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white)
     ![](https://img.shields.io/badge/Swagger-44cc11?style=for-the-badge&logo=swagger&logoColor=white)
     ![](https://img.shields.io/badge/Debian-A81D33?style=for-the-badge&logo=debian&logoColor=white)
     ![](https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
     ![](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

     
<br></br>

## 
   ### 플로우 챠트
   ![flow](https://private-user-images.githubusercontent.com/85206794/294123080-64bcdaf6-3dd1-428d-bae3-b35675db6494.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDQzNTY2OTQsIm5iZiI6MTcwNDM1NjM5NCwicGF0aCI6Ii84NTIwNjc5NC8yOTQxMjMwODAtNjRiY2RhZjYtM2RkMS00MjhkLWJhZTMtYjM1Njc1ZGI2NDk0LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMDQlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTA0VDA4MTk1NFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTc4MDhlY2I2YmI5OWVjMzBiOWRlYWQwOTc0ZGZiZmQyYzEzMGE0ZGQzNTBkNDYzYmEzYTQ3NjY3MGI2ODVkNWUmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.MEXK-7YTeIXLfiLuQ1qLuCdkHl9eH6s4hoWM5HTdI9E)
   
   ### ERD
   ![erd](https://private-user-images.githubusercontent.com/85206794/294123195-2e2cca78-619a-4558-8095-7ee7d6e6630d.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDQzNTY2OTIsIm5iZiI6MTcwNDM1NjM5MiwicGF0aCI6Ii84NTIwNjc5NC8yOTQxMjMxOTUtMmUyY2NhNzgtNjE5YS00NTU4LTgwOTUtN2VlN2Q2ZTY2MzBkLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMDQlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTA0VDA4MTk1MlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTllYWFhMTI5YWQ0NTQxMDk0YjFhM2M1YTdiNzA4MzUxZDBhNGY4NmRkMjQzYzVhZGIwNjlkYWMwYTdmOTA4NjAmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.bJp8BZ359EFFYIaLA8PCeSq8Euwt8dMJoM7kicfjmhM)