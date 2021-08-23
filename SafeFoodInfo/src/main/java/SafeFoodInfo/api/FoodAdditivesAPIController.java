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

import SafeFoodInfo.service.FoodAdditivesService;
import SafeFoodInfo.vo.FoodAdditivesInfoVO;

@RestController
public class FoodAdditivesAPIController {
    @Autowired
    FoodAdditivesService service;

    @GetMapping("/api/food_additives")
    public Map<String, Object> getFoodAdditivesInfo() throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1470000/FoodAdtvInfoService/getFoodAdtvInfoList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=q8DD9W8q4XBY24HHLTo8g7PZalXiw6wnIuWN95KUPIP1Dwy%2FGaKokqcyLTGhjoih9lHQYyP%2FIESNDCddp%2BbP%2Bw%3D%3D"); /*Service Key*/
        // urlBuilder.append("&" + URLEncoder.encode("prdlst_cd","UTF-8") + "=" + URLEncoder.encode("C0118010300000", "UTF-8")); /*품목코드*/
        // urlBuilder.append("&" + URLEncoder.encode("pc_kor_nm","UTF-8") + "=" + URLEncoder.encode("과.채음료", "UTF-8")); /*품목한글명*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getNodeName());
        
        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("파싱할 리스트 수 : "+ nList.getLength());
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message","데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++){
            Node node = nList.item(i);
            Element elem = (Element)node;

            String fa_prdlst_code = getTagValue("PRDLST_CD", elem);
            String fa_pc_kor_name = getTagValue("PC_KOR_NM", elem);
            String fa_testitm_code = getTagValue("TESTITM_CD", elem);
            String fa_t_kor_name = getTagValue("T_KOR_NM", elem);
            String fa_fnprt_itm_name = getTagValue("FNPRT_ITM_NM", elem);
            String fa_spec_val = getTagValue("SPEC_VAL", elem);
            String fa_spec_val_sumup = getTagValue("SPEC_VAL_SUMUP", elem);
            String fa_max_val = getTagValue("MXMM_VAL", elem);
            String fa_min_val = getTagValue("MIMM_VAL", elem);
            String fa_injry_yn = getTagValue("INJRY_YN", elem);
            String fa_unit_name = getTagValue("UNIT_NM", elem);
            String bDt = getTagValue("VALD_BEGN_DT",elem);
            String eDt = getTagValue("VALD_END_DT",elem);
            
            
            FoodAdditivesInfoVO vo = new FoodAdditivesInfoVO();

            
            vo.setFa_prdlst_code(fa_prdlst_code);
            vo.setFa_pc_kor_name(fa_pc_kor_name);
            vo.setFa_testitm_code(fa_testitm_code);
            vo.setFa_t_kor_name(fa_t_kor_name);
            vo.setFa_fnprt_itm_name(fa_fnprt_itm_name);
            vo.setFa_spec_val(fa_spec_val);
            vo.setFa_spec_val_sumup(fa_spec_val_sumup);
            vo.setFa_vald_begn_dt(bDt);
            vo.setFa_vald_end_dt(eDt);
            vo.setFa_max_val(fa_max_val);
            vo.setFa_min_val(fa_min_val);
            vo.setFa_injry_yn(fa_injry_yn);
            vo.setFa_unit_name(fa_unit_name);

            System.out.println(vo);
            service.insertFoodAdditives(vo);          
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
