$(function(){
    /* 플래그 frmSave를 체크한다. */
    // if( '${frmSave}' == "true" ) {
    //     alert("저장되었습니다.");
    //     $('#frmCreate').attr({action : "/board/boardList"}).submit();
    // }
});
$(function(){
    $("#frmInsert").click(function(){
        if( $('#frmTitle').val()=="" || $('#frmTitle').val()==null ){
            alert("제목을 입력하세요.");
            $('#frmTitle').focus();
            return;
        }
        if( $('#frmContents').val()=="" || $('#frmContents').val()==null ){
            alert("본문을 입력하세요.");
            $('#frmContents').focus();
            return;
        }
        if( $('#frmfup').val()!="" && $('#frmfup').val()!=null ){
            //alert("파일 "+$('#frmfup').val()+"를 첨부합니다.");
        }
        
        let writer = $("#writer").val();
        let title = $("#frmTitle").val();
        let content = $("#frmContents").val();
              
        let data = {
            bl_title:title,
            bl_wuser:writer,
            bl_content:content
        }

        $.ajax({
            type:"post",
            url:"/api/board/content",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(r){
                alert(r.message);
                history.back();
            }
        })
    });
    $("#frmCancel").click(function(){
        if(!confirm("이전 페이지로 돌아갑니다.\n(작성중인 내용은 모두 삭제됩니다.)")){
            return;
        }
        history.back();
    });
    
})