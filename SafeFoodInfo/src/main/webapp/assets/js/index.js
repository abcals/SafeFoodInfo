$(function(){
    $.ajax({
        type:"get",
        url:"/api/IncongruityProduct/list",
        success:function(r){
            for(let i=0; i < r.list.length; i++){
                let tag =
                    '<tr>'+
                        '<td>'+r.list[i].ip_bsshnm+'</td>'+
                        '<td>'+r.list[i].ip_prdtnm+'</td>'+
                        '<td>'+r.list[i].ip_cret_dtm+'</td>'+
                        '<td>'+r.list[i].ip_test_itmnm+'</td>'+
                        '<td>'+r.list[i].ip_stdr_stnd+'</td>'+
                        '<td>'+r.list[i].ip_testanals_rslt+'</td>'+
                    "</tr>";
                $(".product_list").append(tag);
            }
        }
    })
    $.ajax({
        type:"get",
        url:"/api/AdministrativeMeasure/list",
        success:function(r){
            for(let i=0; i < r.list.length; i++){
                let tag =
                    '<tr>'+
                        '<td>'+r.list[i].am_prcscitypoint_bsshnm+'</td>'+
                        '<td>'+r.list[i].am_induty_cd_nm+'</td>'+
                        '<td>'+r.list[i].am_dsps_dcsndt+'</td>'+
                        '<td>'+r.list[i].am_dspscn+'</td>'+
                    "</tr>";
                $(".administration_list").append(tag);
            }
        }
    })
    $.ajax({
        type:"get",
        url:"/api/SellStop/list",
        success:function(r){
            console.log(r)
            for(let i=0; i < r.list.length; i++){
                let tag =
                    '<tr>'+
                        '<td>'+r.list[i].ss_prdtnm+'</td>'+
                        '<td>'+r.list[i].ss_bsshnm+'</td>'+
                        '<td>'+r.list[i].ss_prdlst_type+'</td>'+
                        '<td>'+r.list[i].ss_rtrvlprvns+'</td>'+
                        '<td>'+r.list[i].ss_cret_dtm+'</td>'+
                    "</tr>";
                $(".stop_list").append(tag);
            }
        }
    })
})