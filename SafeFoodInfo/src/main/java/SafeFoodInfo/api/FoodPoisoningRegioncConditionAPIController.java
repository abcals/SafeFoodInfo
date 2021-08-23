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

import SafeFoodInfo.service.FoodPoisoningRegioncConditionService;
import SafeFoodInfo.vo.FoodPoisoningRegioncConditionVO;


@RestController
public class FoodPoisoningRegioncConditionAPIController {
    @Autowired
    FoodPoisoningRegioncConditionService service;
    
    @GetMapping("/api/food_poisoning")
        public Map<String, Object> getFoodPoisoningInfo() throws Exception{
            Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
            StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
            urlBuilder.append("/" + URLEncoder.encode("6e683879bddd4137880c","UTF-8")); /*Service Key*/
            urlBuilder.append("/" + URLEncoder.encode("I2848","UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("xml","UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("1","UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("5","UTF-8"));
        
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(urlBuilder.toString());

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");
            if(nList.getLength() <= 0){
                resultMap.put("status", false);
                resultMap.put("message","데이터가 없습니다.");
                return resultMap;
            }
            for(int i=0; i<nList.getLength(); i++){
                Node node = nList.item(i);
                Element elem = (Element)node;
            
                FoodPoisoningRegioncConditionVO vo = new FoodPoisoningRegioncConditionVO();
                vo.setFp_year(getTagValue("OCCRNC_YEAR",elem));
                vo.setFp_mm(getTagValue("OCCRNC_MM",elem));
                vo.setFp_area(getTagValue("OCCRNC_AREA",elem));
                vo.setFp_cnt(Integer.parseInt(getTagValue("OCCRNC_CNT",elem)));
                vo.setFp_patnt(Integer.parseInt(getTagValue("PATNT_CNT",elem)));
                
    
                System.out.println(vo);
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
