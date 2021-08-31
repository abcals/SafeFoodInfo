$(function(){
    $.ajax({
        type:"get",
        url:"/api/childinfo/mealservice",
        success:function(r){
            console.log(r)
            for(let i=0; i < r.list.length; i++){
                let tag =
                    '<tr>'+
                        '<td>'+r.list[i].cm_instt_nm+'</td>'+
                        '<td>'+r.list[i].cm_cnter_nm+'</td>'+
                        '<td>'+r.list[i].cm_report_yr+'</td>'+
                        '<td>'+r.list[i].cm_report_qu+'</td>'+
                        '<td>'+r.list[i].cm_kndrgr_reg_co+'</td>'+
                        '<td>'+r.list[i].cm_kndrgr_nmpr_co+'</td>'+
                        '<td>'+r.list[i].cm_dccntr_reg_co+'</td>'+
                        '<td>'+r.list[i].cm_dccntr_nmpr_co+'</td>'+
                        '<td>'+r.list[i].cm_etc_reg_co+'</td>'+
                        '<td>'+r.list[i].cm_etc_nmpr_co+'</td>'
                    "</tr>";
                $(".mealservice_list").append(tag);
            }
        }
    })
})