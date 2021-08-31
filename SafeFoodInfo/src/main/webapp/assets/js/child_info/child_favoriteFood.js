$(function(){
    $("#enterprise_name").change(function(){
        $(".favorite_food_list").empty();
        let enterprise = $("#enterprise_name").find("option:selected").val();
        getFavoriteFoodList(enterprise)
    });
    function formatDate(date){
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;
        return [year, month, day].join('-');
    }

    getFavoriteFoodList("(주)개미식품")
    function getFavoriteFoodList(enterprise){
        let url = "/api/childinfo/quality/enterprise?enterprise="+enterprise
        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                console.log(r)
                for(let i=0; i < r.list.length; i++){
                    let tag =
                        '<tr>'+
                            '<td>'+r.list[i].cq_prdlst_nm+'</td>'+
                            '<td>'+r.list[i].cq_prdlst_cd_nm+'</td>'+
                            '<td>'+r.list[i].cq_cn_wt+'</td>'+
                            '<td>'+formatDate(r.list[i].cq_appn_bgn_dt)+'</td>'+
                            '<td>'+formatDate(r.list[i].cq_appn_end_dt)+'</td>'
                        "</tr>";
                    $(".favorite_food_list").append(tag);
                }
            }
        })
    };
})