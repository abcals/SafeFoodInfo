package SafeFoodInfo.api;

import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import SafeFoodInfo.service.HealthFood_IngredientService;
import SafeFoodInfo.vo.healthfood_vo.HealthFood_IngredientVO;

@RestController
public class HealthFood_IngredientAPIController {
    @Autowired
    HealthFood_IngredientService service;
    
    @GetMapping("/api/HealthFood_Ingredient")
    public Map<String, Object> getHealthFoodIngredientInfo()throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
        urlBuilder.append("/" + URLEncoder.encode("sample","UTF-8")); /*6e683879bddd4137880c*/
        urlBuilder.append("/" + URLEncoder.encode("I-0050","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("xml","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("1","UTF-8"));
        urlBuilder.append("/" + URLEncoder.encode("100","UTF-8"));

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
        
            HealthFood_IngredientVO vo = new HealthFood_IngredientVO();
            vo.setHfi_pawmtrl_nm(getTagValue("RAWMTRL_NM",elem));
            vo.setHfi_hf_fnclty_mtral_rcpgn_no(getTagValue("HF_FNCLTY_MTRAL_RCOGN_NO",elem));
            vo.setHfi_iftkn_atnt_matr_cn(getTagValue("IFTKN_ATNT_MATR_CN",elem));
            vo.setHfi_wt_unit(getTagValue("WT_UNIT",elem));
            vo.setHfi_day_intk_highlimit(getTagValue("DAY_INTK_HIGHLIMIT",elem));
            vo.setHfi_day_intk_lowlimit(getTagValue("DAY_INTK_LOWLIMIT",elem));
            vo.setHfi_primary_fnclty(getTagValue("PRIMARY_FNCLTY",elem));
            

            System.out.println(vo);
            service.insertHealthFoodIndividuelIngredient(vo);
            
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
}
