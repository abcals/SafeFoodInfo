<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/member/member_join.js"></script> 
</head>
<body>
    <div class="wrap">
        <div class="header">
            <%@include file="/WEB-INF/views/includes/menu.jsp"%>
        </div>
        <div class="body">
            <h1 class="title">회원가입</h1>
            <table class="join_table">
                <tbody>
                    <tr>
                        <td>아이디</td>
                        <td colspan="3">
                            <input type="text" id="user_id">
                        </td>
                        <td>
                            <button id="chk_id">중복확인</button>
                        </td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td colspan="3">
                            <input type="password" id="user_pwd" class="pw" placeholder="비밀번호를 입력해주세요.">
                        </td>
                    </tr>
                    <tr>
                        <td>비밀번호 확인</td>
                        <td colspan="3">
                            <input type="password" id="user_pwd_confirm" class="pw" placeholder="비밀번호 확인">
                            <span id="alert_success" style="display: none;">비밀번호가 일치합니다.</span>
                            <span id="alert_danger" style="display:none; color: #d92742; font-weight: bold;">비밀번호가 일치하지 않습니다.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td colspan="3">
                            <input type="text" id="user_name">
                        </td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td colspan="3">
                            <input type="text" id="user_email">
                        </td>
                        <td>
                            <button id="chk_email">중복확인</button>
                        </td>
                    </tr>
                    <tr>
                        <td>생년월일</td>
                        <td>
                            <input type="text" id="user_birth_year" placeholder="년도">
                        </td>
                        <td>
                            <input type="text" id="user_birth_month" placeholder="월">
                        </td>
                        <td>
                            <input type="text" id="user_birth_date" placeholder="일">
                        </td>
                    </tr>
                    <tr>
                        <td>성별</td>
                        <td colspan="3">
                            <select id="user_gen">
                                <option value="0" selected>남</option>
                                <option value="1">여</option>
                                <option value="2">선택안함</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td colspan="3">
                            <input type="text" id="user_phone">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <button id="join">회원가입</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>