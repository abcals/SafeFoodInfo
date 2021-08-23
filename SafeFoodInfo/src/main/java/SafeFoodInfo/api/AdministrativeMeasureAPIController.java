package SafeFoodInfo.api;

import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
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

import SafeFoodInfo.service.AdministrativeMeasureService;
import SafeFoodInfo.vo.AdministrativeMeasureVO;

@RestController
public class AdministrativeMeasureAPIController {
    @Autowired
    AdministrativeMeasureService service;

    @GetMapping("/api/AdministrativeMeasure")
    public Map<String, Object> getAdministrativeMeasure()throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
        urlBuilder.append("/" + URLEncoder.encode("6e683879bddd4137880c","UTF-8")); /*6e683879bddd4137880c*/
        urlBuilder.append("/" + URLEncoder.encode("I0470","UTF-8"));
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
        
            AdministrativeMeasureVO vo = new AdministrativeMeasureVO();
            vo.setAm_prcscitypoint_bsshnm(getTagValue("PRCSCITYPOINT_BSSHNM",elem));
            vo.setAm_dsps_insttcd_nm(getTagValue("DSPS_INSTTCD_NM",elem));
            vo.setAm_dsps_enddt(getTagValue("DSPS_ENDDT",elem));
            vo.setAm_vltcn(getTagValue("VILTCN",elem));
            vo.setAm_dsps_bgndt(getTagValue("DSPS_BGNDT",elem));
            vo.setAm_laword_cd_nm(getTagValue("LAWORD_CD_NM",elem));
            vo.setAm_dsps_typecd_nm(getTagValue("DSPS_TYPECD_NM",elem));
            vo.setAm_dsps_dcsndt(getTagValue("DSPS_DCSNDT",elem));
            vo.setAm_dspscn(getTagValue("DSPSCN",elem));
            vo.setAm_last_updt_dtm(getTagValue("LAST_UPDT_DTM",elem));
            vo.setAm_induty_cd_nm(getTagValue("INDUTY_CD_NM",elem));
            vo.setAm_addr(getTagValue("ADDR",elem));
            

            System.out.println(vo);
            service.insertAdministrativeMeasure(vo);  
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
    @GetMapping("/api/AdministrativeMeasure/list")
    public Map<String, Object> AdministrativeMeasure_topList(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<AdministrativeMeasureVO> list = service.selectAdministrativeMeasure_topList();
        resultMap.put("list", list);

        return resultMap;
    }
}