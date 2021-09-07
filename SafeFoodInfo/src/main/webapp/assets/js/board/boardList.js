$(function(){
    $.ajax({
        type:"get",
        url:"/api/board/content/list",
        success:function(r){
            console.log(r)
            for(let i=0; i < r.list.length; i++){
                let tag =
                    '<tr>'+
                        '<td>'+'글 번호'+'</td>'+
                        '<td>'+r.list[i].bl_title+'</td>'+
                        '<td>'+r.list[i].bl_wuser+'</td>'+
                        '<td>'+r.list[i].bl_wdate+'</td>'+
                        '<td>'+r.list[i].bl_mdate+'</td>'+
                        '<td>'+'조회수'+'</td>'
                    "</tr>";
                $(".content").append(tag);
            }
        }
    })
});