<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새로이 글쓰기</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/board/boardCreate.js"></script> 
</head>
<body>
    <h2 style="padding:0.1em 1em;">새로이 글쓰기</h2>
    ${member}
    <input type="text" id="writer" value="${member.mi_name}" disabled hidden>
    <!-- 파일 첨부를 위해서는 multipart/form-data를 추가해야 한다. -->
    <div class="content">
      <table id="tcreate" border="1px dashed #EEEEEE" width="50%">
        <thead>
          <tr>
            <th>제목</th>
            <!-- input type이 text -->
            <td><input id="frmTitle" name="frmTitle" type="text" onkeydown="if(event.keyCode==13) fnSave()" style="height:auto;width:90%;color:#010101"/></td>
          </tr>        
        </thead>
        <tbody>
          <tr>
            <th>본문</th>
            <!-- input type이 textarea -->
            <td><textarea id="frmContents" name="frmContents" cols="50%" rows="10%" style="color:#010101;"></textarea></td>
          </tr>
          <tr>
            <th>파일첨부</th>
            <!-- input type이 file -->
            <td><input style="font-family:'바탕체', Georgia, serif;font-size:14px;" type="file" id="frmfup" name="frmfup"/></td>
          </tr>
        </tbody>
      </table>
    
      <br />
      <div class="mybutton">
        <input id="frmInsert" name="frmInsert" type="button" value="저장" />
        <input id="frmCancel" name="frmCancel" type="button" value="글쓰기 취소" />
      </div>
    </div>
</body>
</html>