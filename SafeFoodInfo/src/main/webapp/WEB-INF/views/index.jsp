<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>식품안전정보</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.0/dist/chart.min.js"></script>
    <script src="/assets/js/index.js"></script> 
</head>
<body>
    <div class="wrap">
        <div class="header">
            <%@include file="/WEB-INF/views/includes/menu.jsp"%>
        </div>
        <div class="container">
            <div class="container_left">
                <div class="chart_area">
                    <div class="accident_cnt chart_left">
                        <canvas id="regional_good_store" style="width:100%;"></canvas>
                        <span>어린이 우수 판매업소 현황&nbsp <select id="region_select">
                            <option value="서울">서울특별시</option>
                            <option value="경기">경기도</option>
                            <option value="인천">인천광역시</option>
                            <option value="부산">부산광역시</option>
                            <option value="대구">대구광역시</option>
                            <option value="울산">울산광역시</option>
                            <option value="광주">광주광역시</option>
                            <option value="대전">대전광역시</option>
                            <option value="경남">경상남도</option>
                            <option value="경북">경상북도</option>
                            <option value="전남">전라남도</option>
                            <option value="전북">전라북도</option>
                            <option value="충남">충청남도</option>
                            <option value="충북">충청북도</option>
                            <option value="강원">강원도</option>
                            <option value="제주">제주특별자치도</option>
                        </select></span>                     
                    </div>
                    <div class="patient_cnt chart_right">
                        <canvas id="enterprise_favorite_food" style="width:100%;"></canvas>
                        <span>기업별 기호식품 품질인증 현황</span>
                    </div>
                </div>
                <div class="list_area">
                    <div class="list_top">
                        <table>
                            <thead>
                                <tr class="product_top">        
                                    <td>업소명</td>
                                    <td>제품명</td>
                                    <td>등록일</td>
                                    <td>부적합 항목</td>
                                    <td>기준규격</td>
                                    <td>검사결과</td>
                                </tr>
                            </thead>
                            <tbody class = "product_list">

                            </tbody>
                            <tfoot>
                                <td>
                                    <a href="/test" id = "list_link">검사 부적합 상세 리스트</a>
                                </td>
                            </tfoot>
                        </table>
                    </div>
                    <div class="list_middle">
                        <table>
                            <thead>
                                <tr>
                                    <td>업소명</td>
                                    <td>업종</td>
                                    <td>처분확정일자</td>
                                    <td>처분내용</td>
                                </tr>
                            </thead>
                            <tbody class = "administration_list">

                            </tbody>
                            <tfoot>
                                <td>
                                    <a href="/result" id = "list_link">행정처분결과 상세 리스트</a>
                                </td>
                            </tfoot>
                        </table>
                    </div>
                    <div class="list_bottom">
                        <table>
                            <thead>
                                <tr>
                                    <td>제품명</td>
                                    <td>제조업체명</td>
                                    <td>식품분류</td>
                                    <td>회수사유</td>
                                    <td>등록일</td>
                                </tr>
                            </thead>
                            <tbody class = "stop_list">

                            </tbody>
                            <tfoot>
                                <td>
                                    <a href="/stop" id = "list_link">회수판매중지 상세 리스트</a>
                                </td>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
            <div class="container_right">
                <div class="weather_area">
                    <p>날씨</p>
                </div>
                <div class="poison_index">
                    <p>식중독 지수</p>
                </div>
            </div>
        </div>
        <div class="footer">

        </div>
    </div>
</body>
</html>