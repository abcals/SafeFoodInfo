<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>어린이 우수판매업소</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/child_info/child_goodstore.js"></script> 
</head>
<body>
    <h1>어린이 우수판매업소</h1>
    <div class="wrap">
        <div class="header">
            <%@include file="/WEB-INF/views/includes/child.jsp"%>
        </div>
        <div class="container">
            <div class="list_area">
                <span>지역선택&nbsp <select id="region_select">
                    <option value="null" disabled>지역선택</option>
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
                <table>
                    <thead>
                        <tr class="goodstore_top">        
                            <td>업소명</td>
                            <td>업종</td>
                            <td>주소</td>
                        </tr>
                    </thead>
                    <tbody class = "goodstore_list">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>