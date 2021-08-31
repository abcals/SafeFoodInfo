<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기호식품 품질인증 현황</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/child_info/child_favoriteFood.js"></script> 
</head>
<body>
    <h1>기호식품 품질인증 현황</h1>
    <div class="wrap">
        <div class="header">
            <%@include file="/WEB-INF/views/includes/child.jsp"%>
        </div>
        <div class="container">
            <span>기업선택</span>
            <select id="enterprise_name">
                <option value="null" disabled>기업선택</option>
                <c:forEach items="${list}" var="data">
                    <option value="${data.e_name}">${data.e_name}</option>
                </c:forEach>
            </select>
            <table>
                <thead>
                    <tr class="favorite_food_top">        
                        <td>제품명</td>
                        <td>식품유형</td>
                        <td>제품용량</td>
                        <td>인증일자</td>
                        <td>만료일자</td>
                    </tr>
                </thead>
                <tbody class = "favorite_food_list">

                </tbody>
            </table>
        </div> 
    </div>
</body>
</html>