package SafeFoodInfo.api;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import SafeFoodInfo.service.ChildInfoService;
import SafeFoodInfo.vo.child_vo.ChildFavoriteFoodQualityVO;
import SafeFoodInfo.vo.child_vo.ChildFoodSafeAreaVO;
import SafeFoodInfo.vo.child_vo.ChildGoodStoreVO;
import SafeFoodInfo.vo.child_vo.ChildMealServiceCenterVO;

@RestController
public class ChildInfoAPIController {
    @Autowired
    ChildInfoService service;

    @GetMapping("/api/childinfo/center")
    public Map<String, Object> getChildCenterInfo() throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
        urlBuilder.append("/" + URLEncoder.encode("6e683879bddd4137880c","UTF-8")); /*6e683879bddd4137880c*/
        urlBuilder.append("/" + URLEncoder.encode("I2846","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("xml","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1000","UTF-8"));

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("row");
        System.out.println(urlBuilder);
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message","데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            Node node = nList.item(i);
            Element elem = (Element)node;
      
            ChildMealServiceCenterVO vo = new ChildMealServiceCenterVO();
            vo.setCm_instt_nm(getTagValue("INSTT_NM",elem));
            vo.setCm_cnter_nm(getTagValue("CNTER_NM",elem));
            vo.setCm_report_yr(getTagValue("REPORT_YR",elem));
            vo.setCm_report_qu(getTagValue("REPORT_QU",elem));
            vo.setCm_kndrgr_reg_co(Integer.parseInt(getTagValue("KNDRGR_REG_CO",elem)));
            vo.setCm_kndrgr_nmpr_co(Integer.parseInt(getTagValue("KNDRGR_NMPR_CO",elem)));
            vo.setCm_dccntr_reg_co(Integer.parseInt(getTagValue("DCCNTR_REG_CO",elem)));
            vo.setCm_dccntr_nmpr_co(Integer.parseInt(getTagValue("DCCNTR_NMPR_CO",elem)));
            vo.setCm_etc_reg_co(Integer.parseInt(getTagValue("ETC_REG_CO",elem)));
            vo.setCm_etc_nmpr_co(Integer.parseInt(getTagValue("ETC_NMPR_CO",elem)));

            service.insertChildMealServiceCenter(vo);                                     
        }
        resultMap.put("status", true);
        resultMap.put("message","데이터가 입력되었습니다.");

        return resultMap;
    }
    
    public static String getTagValue(String tag, Element elem){
        NodeList nlList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        if(nlList == null) return null;
        Node node = (Node) nlList.item(0);
        if(node == null) return null;
        return node.getNodeValue(); 
    }

    @GetMapping("/api/childinfo/store")
    public Map<String, Object> getChildGoodStore()throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
        urlBuilder.append("/" + URLEncoder.encode("6e683879bddd4137880c","UTF-8")); /*6e683879bddd4137880c*/
        urlBuilder.append("/" + URLEncoder.encode("I2840","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("xml","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1000","UTF-8"));

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("row");
        System.out.println(urlBuilder);
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message","데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            Node node = nList.item(i);
            Element elem = (Element)node;
      
            ChildGoodStoreVO vo = new ChildGoodStoreVO();
            vo.setCg_gnt_no(getTagValue("GNT_NO",elem));
            vo.setCg_upso_nm(getTagValue("UPSO_NM",elem));
            vo.setCg_upjong(getTagValue("UPJONG",elem));
            vo.setCg_addr(getTagValue("ADDR",elem));
            vo.setCg_hold_instt_cd(getTagValue("HOLD_INSTT_CD",elem));

            String createDt = getTagValue("APLC_DT",elem);
            Date cDt = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            cDt = formatter.parse(createDt);
            vo.setCg_aplc_dt(cDt);

            service.insertChildGoodStore(vo);
        }
        resultMap.put("status", true);
        resultMap.put("message","데이터가 입력되었습니다.");
        return resultMap;
    }
    @GetMapping("/api/childinfo/safe")
    public Map<String, Object> getChildFoodSafeStore() throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
        urlBuilder.append("/" + URLEncoder.encode("6e683879bddd4137880c","UTF-8")); /*6e683879bddd4137880c*/
        urlBuilder.append("/" + URLEncoder.encode("I0340","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("xml","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("15901","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("16900","UTF-8"));

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("row");
        System.out.println(urlBuilder);
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message","데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            Node node = nList.item(i);
            Element elem = (Element)node;
      
            ChildFoodSafeAreaVO vo = new ChildFoodSafeAreaVO();
            vo.setCf_upso_nm(getTagValue("UPSO_NM",elem));
            vo.setCf_bssh_no(getTagValue("BSSH_NO",elem));
            vo.setCf_upjong(getTagValue("UPJONG",elem));
            vo.setCf_hold_instt_nm(getTagValue("HOLD_INSTT_NM",elem));
            vo.setCf_food_safe_prtc_zone_nm(getTagValue("FOOD_SAFE_PRTC_ZONE_NM",elem));
            vo.setCf_addr(getTagValue("ADDR",elem));
            vo.setCf_schl_nm(getTagValue("SCHL_NM",elem));

            service.insertChildFoodSafeArea(vo);
        }
        resultMap.put("status", true);
        resultMap.put("message","데이터가 입력되었습니다.");
        return resultMap;
    }
    
    @GetMapping("/api/childinfo/quality")
    public Map<String, Object> getChildFavoriteFoodQuality() throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
        urlBuilder.append("/" + URLEncoder.encode("6e683879bddd4137880c","UTF-8")); /*6e683879bddd4137880c*/
        urlBuilder.append("/" + URLEncoder.encode("I0080","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("xml","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1000","UTF-8"));

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("row");
        System.out.println(urlBuilder);
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message","데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            Node node = nList.item(i);
            Element elem = (Element)node;
      
            ChildFavoriteFoodQualityVO vo = new ChildFavoriteFoodQualityVO();
            vo.setCq_child_ffq_crtfc_no(getTagValue("CHILD_FFQ_CRTFC_NO",elem));
            vo.setCq_bssh_nm(getTagValue("BSSH_NM",elem));
            vo.setCq_lcns_no(getTagValue("LCNS_NO",elem));
            vo.setCq_prdlst_cd_nm(getTagValue("PRDLST_CD_NM",elem));
            vo.setCq_prdlst_nm(getTagValue("PRDLST_NM",elem));
            vo.setCq_cn_wt(getTagValue("CN_WT",elem));
            vo.setCq_child_favor_food_type_nm(getTagValue("CHILD_FAVOR_FOOD_TYPE_NM",elem));
            
            String createDt = getTagValue("APPN_BGN_DT",elem);
            String endDt = getTagValue("APPN_END_DT",elem);
            Date cDt = new Date();
            Date eDt = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            cDt = formatter.parse(createDt);
            eDt = formatter.parse(endDt);
            vo.setCq_appn_bgn_dt(cDt);
            vo.setCq_appn_end_dt(eDt);

            service.insertChildFavoriteFoodQuality(vo);
        }
        resultMap.put("status", true);
        resultMap.put("message","데이터가 입력되었습니다.");

        return resultMap;
    }

    @GetMapping("/api/childinfo/quality/chart")
    public Map<String, Object> getEnterpriseCnt(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<ChildFavoriteFoodQualityVO> list = service.selectEnterpriseCnt();
        resultMap.put("list", list);

        return resultMap;
    }

    @GetMapping("/api/childinfo/goodstore")
    public Map<String, Object> getGoodStoreCnt(@RequestParam String regional){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        char[] c = regional.toCharArray();
        regional = "%"+c[0]+"%"+c[1]+"%";

        List<ChildGoodStoreVO> g_list = service.selectRegionalGoodStoreCnt(regional);
        resultMap.put("list", g_list);

        return resultMap;
    }

    @GetMapping("/api/childinfo/goodstore/list")
    public Map<String, Object> getGoodStoreList(@RequestParam String region){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        char[] c = region.toCharArray();
        region = "%"+c[0]+"%"+c[1]+"%";

        List<ChildGoodStoreVO> list = service.selectRegionalGoodStoreList(region);
        resultMap.put("list", list);

        return resultMap;
    }
    @GetMapping("/api/childinfo/mealservice")
    public Map<String, Object> getMealServiceList(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<ChildMealServiceCenterVO> list = service.selectMealServiceList();
        resultMap.put("list", list);

        return resultMap;
    }

    @GetMapping("/api/childinfo/quality/enterprise")
    public Map<String, Object> getEnterpriseFavoriteFood(@RequestParam String enterprise){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<ChildFavoriteFoodQualityVO> list = service.selectEnterpriseFavoriteFood(enterprise);
        resultMap.put("list", list);

        return resultMap;
    }
}