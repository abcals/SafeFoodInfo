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
                        <p>차트영역 왼쪽</p>
                    </div>
                    <div class="patient_cnt chart_right">
                        <p>차트영역 오른쪽</p>
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
                <div class="child_area">
                    <a href="/child_info">어린이 정보</a>
                </div>
            </div>
        </div>
        <div class="footer">

        </div>
    </div>
</body>
</html>