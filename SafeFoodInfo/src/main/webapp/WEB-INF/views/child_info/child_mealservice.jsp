<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>급식센터 지원현황</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/child_info/child_mealservice.js"></script> 
</head>
<body>
    <h1>급식센터 지원현황</h1>
    <div class="wrap">
        <div class="header">
            <%@include file="/WEB-INF/views/includes/child.jsp"%>
        </div>
        <div class="container">
            <table>
                <thead>
                    <tr>
                        <td>관할기관</td>
                        <td>센터명</td>
                        <td>년도</td>
                        <td>분기</td>
                        <td>유치원 수</td>
                        <td>유치원 인원수</td>
                        <td>어린이집 수</td>
                        <td>어린이집 인원수</td>
                        <td>기타 수</td>
                        <td>기타 인원수</td>
                    </tr>
                </thead>
                <tbody class = "mealservice_list">

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>