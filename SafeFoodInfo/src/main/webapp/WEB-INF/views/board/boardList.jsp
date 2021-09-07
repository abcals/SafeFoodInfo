<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>게시판 목록</title>
        <link rel="stylesheet" href="/assets/css/reset.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
    	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="/assets/js/board/boardList.js"></script>
    </head>
    <body>
        <div class="list">
            <div class="top">
                <h2 style="padding:0.1em 1em;">게시판 목록</h2>
                <input id="goCreate" name="goCreate" type="button" onclick="location.href='/board/boardCreate'" value="새로이 글쓰기" />
            </div>
            <div class="mid">
                <input type="hidden" id="frmSeq" name="frmSeq" />
                <table id="tlist" border="1px dashed #EEEEEE">
                    <thead>
                        <tr>
                            <td>글번호</td>
                            <td>제 목</td>
                            <td>작성자</td>
                            <td>작성일</td>
                            <td>수정일</td>
                            <td>조회수</td>
                        </tr>
                    </thead>
                    <tbody class="content">

                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>