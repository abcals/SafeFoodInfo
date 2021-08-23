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

import SafeFoodInfo.service.IncongruityProductInfoService;
import SafeFoodInfo.vo.IncongruityProductInfoVO;

@RestController
public class IncongruityProductInfoAPIController {
    @Autowired
    IncongruityProductInfoService service;

    @GetMapping("/api/IncongruityProduct")
    public Map<String, Object> getIncongruityProduct() throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
        urlBuilder.append("/" + URLEncoder.encode("6e683879bddd4137880c","UTF-8")); /*6e683879bddd4137880c*/
        urlBuilder.append("/" + URLEncoder.encode("I2620","UTF-8"));
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
        
            IncongruityProductInfoVO vo = new IncongruityProductInfoVO();
            vo.setIp_frmlcunit(getTagValue("FRMLCUNIT",elem));
            vo.setIp_testanals_rslt(getTagValue("TESTANALS_RSLT",elem));
            vo.setIp_bsshnm(getTagValue("BSSHNM",elem));
            vo.setIp_distbtmlmt(getTagValue("DISTBTMLMT",elem));
            vo.setIp_brcdno(getTagValue("BRCDNO",elem));
            vo.setIp_rtrvldsuse_seq(getTagValue("RTRVLDSUSE_SEQ",elem));
            vo.setIp_cret_dtm(getTagValue("CRET_DTM",elem));
            vo.setIp_prdlst_report_no(getTagValue("PRDLST_REPORT_NO",elem));
            vo.setIp_mnfdt(getTagValue("MNFDT",elem));
            vo.setIp_prdtnm(getTagValue("PRDTNM",elem));
            vo.setIp_lcns_no(getTagValue("LCNS_NO",elem));
            vo.setIp_stdr_stnd(getTagValue("STDR_STND",elem));
            vo.setIp_addr(getTagValue("ADDR",elem));
            vo.setIp_test_itmnm(getTagValue("TEST_ITMNM",elem));
            vo.setIp_instt_nm(getTagValue("INSTT_NM",elem));
            
            System.out.println(vo);
            service.insertIncongruityProductInfo(vo);

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
    @GetMapping("/api/IncongruityProduct/list")
    public Map<String, Object> selectIncongruityProductInfo_topList(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<IncongruityProductInfoVO> list = service.selectIncongruityProductInfo_topList();
        resultMap.put("list", list);

        return resultMap;
    }
}
