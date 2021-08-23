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

import SafeFoodInfo.service.FoodNutritionInfoService;
import SafeFoodInfo.vo.FoodNutritionInfoVO;

@RestController
public class FoodNutritionAPIController {
    @Autowired
    FoodNutritionInfoService service;

    @GetMapping("/api/food_nutrition")
    public Map<String, Object> getFoodNutritionInfo() throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1470000/FoodNtrIrdntInfoService/getFoodNtrItdntList"); 
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=q8DD9W8q4XBY24HHLTo8g7PZalXiw6wnIuWN95KUPIP1Dwy%2FGaKokqcyLTGhjoih9lHQYyP%2FIESNDCddp%2BbP%2Bw%3D%3D"); /*Service Key*/
        for(int i = 1; i < 100; i++){
            String s;
            s = Integer.toString(i);
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(s, "UTF-8"));
        }
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8"));
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("item");
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message","데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            Node node = nList.item(i);
            Element elem = (Element)node;
        
            FoodNutritionInfoVO vo = new FoodNutritionInfoVO();
            vo.setFni_serving_wt(getTagValue("SERVING_WT",elem));
            vo.setFni_kcal(getTagValue("NUTR_CONT1",elem));
            vo.setFni_carbohydrate(getTagValue("NUTR_CONT2",elem));
            vo.setFni_protein(getTagValue("NUTR_CONT3",elem));
            vo.setFni_fat(getTagValue("NUTR_CONT4",elem));
            vo.setFni_saccharide(getTagValue("NUTR_CONT5",elem));
            vo.setFni_sodium(getTagValue("NUTR_CONT6",elem));
            vo.setFni_cholesterol(getTagValue("NUTR_CONT7",elem));
            vo.setFni_saturated_fat(getTagValue("NUTR_CONT8",elem));
            vo.setFni_trans_fat(getTagValue("NUTR_CONT9",elem));
            vo.setFni_name(getTagValue("DESC_KOR",elem));
            vo.setFni_bgn_year(getTagValue("BGN_YEAR",elem));

            System.out.println(vo);
            service.insertFoodNutritionInfo(vo);
            
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
  