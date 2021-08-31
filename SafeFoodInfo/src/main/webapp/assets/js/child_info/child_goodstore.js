$(function(){
    $("#region_select").change(function(){
        $(".goodstore_list").empty();
        let region = $("#region_select").find("option:selected").val();
        getGoodStoreList(region)
    });

    getGoodStoreList("서울")
    function getGoodStoreList(region){
        let url = "/api/childinfo/goodstore/list?region="+region
        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                console.log(r)
                for(let i=0; i < r.list.length; i++){
                    let tag =
                        '<tr>'+
                            '<td>'+r.list[i].cg_upso_nm+'</td>'+
                            '<td>'+r.list[i].cg_upjong+'</td>'+
                            '<td>'+r.list[i].cg_addr+'</td>'
                        "</tr>";
                    $(".goodstore_list").append(tag);
                }
            }
        })
    };
})