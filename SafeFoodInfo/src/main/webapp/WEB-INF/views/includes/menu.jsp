<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/index.css"> 
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/menu.js"></script>
</head>
<body>
    <div class="top_menu">
        <a href="/" id="logo">그림</a>
        <ul class="main_menu">
            <li>
                <a href="/foodinfo">식품정보</a>
            </li>
            <li>
                <a href="/healthfoodinfo">건강기능식품</a>
            </li>
            <li>
                <a href="/foodadditives">식품첨가물</a>
            </li>
            <li>
                <a href="/child_info">어린이</a>
            </li>
            <li>
                <a href="/board">게시판</a>
            </li>
        </ul>
    </div>
    <div class="user_menu">
        <c:if test="${empty member}">
            <a href="/join">회원가입</a>
            <span>|</span>
            <a href="/login">로그인</a>
        </c:if>
        <c:if test="${not empty member}">
            <a href="#">
                ${member.mi_name}님
            </a>
            <span>|</span>
            <!-- <a href="/member/logout">로그아웃</a> -->
            <a href="#" id="logout">로그아웃</a>
        </c:if>
    </div>
</body>
</html>