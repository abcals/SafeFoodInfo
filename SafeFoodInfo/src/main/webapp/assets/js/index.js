$(function(){
    function formatDate(date){
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;
        return [year, month, day].join('-');
    }
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
            for(let i=0; i < r.list.length; i++){
                let tag =
                    '<tr>'+
                        '<td>'+r.list[i].ss_prdtnm+'</td>'+
                        '<td>'+r.list[i].ss_bsshnm+'</td>'+
                        '<td>'+r.list[i].ss_prdlst_type+'</td>'+
                        '<td>'+r.list[i].ss_rtrvlprvns+'</td>'+
                        '<td>'+formatDate(r.list[i].ss_cret_dtm)+'</td>'+
                    "</tr>";
                $(".stop_list").append(tag);
            }
        }
    })
    $.ajax({
        type:"get",
        url:"/api/childinfo/quality/chart",
        success:function(r){
            let cnt = new Array();
            let enterpriseLabel = new Array(); 
            for(let i=0; i<r.list.length; i++){
                cnt.push(r.list[i].cnt);
                enterpriseLabel.push(r.list[i].cq_bssh_nm);
            }
            let cntChart = new Chart($("#enterprise_favorite_food"),{
                type:"bar",
                options:{
                    responsive:false,
                },
                data:{
                    labels:enterpriseLabel,
                    datasets:[
                        {
                            label:"10개 이상 기호식품 품질인증을 받은 기업 통계",
                            data:cnt,
                            backgroundColor:["rgba(30, 255, 30, 0.4)"]
                        }
                    ]
                }
            })
        }
    });
})
$(function(){
    var g_cntChart = new Chart($("#regional_good_store"),{
        type:"bar",
        options:{
            responsive:false
        },
        data:{
            labels:null,
            datasets:null
        }
    })
    $("#region_select").change(function(){
        let region = $("#region_select").find("option:selected").val();
        getGoodStore(region)
    });
    getGoodStore("서울")
    function getGoodStore(region){
        let url = "/api/childinfo/goodstore?regional="+region
        $.ajax({
            type:"get",
            url:url,
            success:function(r){
                console.log(r)
                let g_cnt = new Array();
                let goodfoodLabel = new Array(); 
                for(let i=0; i<r.list.length; i++){
                    g_cnt.push(r.list[i].g_cnt);
                    goodfoodLabel.push(r.list[i].cg_hold_instt_cd);
                }
                g_cntChart.data.datasets = new Array();
                g_cntChart.data.labels = goodfoodLabel;

                g_cntChart.data.datasets.push({
                    label:'지역별 우수판매업소 현황', data:g_cnt,
                    backgroundColor:['rgba(30, 30, 255, 0.7)']
                    })
                g_cntChart.update();
            }
        })
    };
})