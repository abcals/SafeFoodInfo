<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/member/login.js"></script>
</head>
<body>

    <div class="wrap">
        <div class="header">
            <a href="/">로고</a>
        </div>
        <div class="login_form">
            <table>
                <tr>
                    <td>
                        <h1>사용자 로그인</h1>
                    </td>
                </tr>
                <tr>
                    <td>
                    <input type="text" placeholder="아이디" id="user_id">
                    <td>
                </tr>
                <tr>
                    <td>
                        <input type="password" placeholder="비밀번호" id="user_pwd">
                    </td>
                </tr>
                <tr>
                    <td>
                        <button id="login_btn">로그인</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="#">비밀번호 찾기</a>
                        <span>|</span>
                        <a href="#">아이디 찾기</a>
                        <span>|</span>
                        <a href="/join">회원가입</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="/">로그인 취소</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>