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
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import SafeFoodInfo.service.SellStopService;
import SafeFoodInfo.vo.SellStopVO;

@RestController
public class SellStopAPIController {
    @Autowired
    SellStopService service;
    @GetMapping("/api/SellStop")
    public Map<String, Object> getSellStop()throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api"); 
        urlBuilder.append("/" + URLEncoder.encode("6e683879bddd4137880c","UTF-8")); /*6e683879bddd4137880c*/
        urlBuilder.append("/" + URLEncoder.encode("I0490","UTF-8"));
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

            String createDt = getTagValue("CRET_DTM",elem);
            Date cDt = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cDt = formatter.parse(createDt);
        
            SellStopVO vo = new SellStopVO();
            vo.setSs_prdtnm(getTagValue("PRDTNM",elem));
            vo.setSs_rtrvlprvns(getTagValue("RTRVLPRVNS",elem));
            vo.setSs_bsshnm(getTagValue("BSSHNM",elem));
            vo.setSs_addr(getTagValue("ADDR",elem));
            vo.setSs_prcscitypoint_telno(getTagValue("PRCSCITYPOINT_TELNO",elem));
            vo.setSs_brcdno(getTagValue("BRCDNO",elem));
            vo.setSs_frmlcunit(getTagValue("FRMLCUNIT",elem));
            vo.setSs_mnfdt(getTagValue("MNFDT",elem));
            vo.setSs_rtrvlplandoc_rtrvlmthd(getTagValue("RTRVLPLANDOC_RTRVLMTHD",elem));
            vo.setSs_distbtmlmt(getTagValue("DISTBTMLMT",elem));
            vo.setSs_prdlst_type(getTagValue("PRDLST_TYPE",elem));
            vo.setSs_img_file_path(getTagValue("IMG_FILE_PATH",elem));
            vo.setSs_prdlst_cd(getTagValue("PRDLST_CD",elem));
            vo.setSs_cret_dtm(cDt);
            vo.setSs_rtrvldsuse_seq(getTagValue("RTRVLDSUSE_SEQ",elem));
            vo.setSs_prdlst_report_no(getTagValue("PRDLST_REPORT_NO",elem));
            vo.setSs_rtrvl_grdcd_nm(getTagValue("RTRVL_GRDCD_NM",elem));
            vo.setSs_prdlst_cd_nm(getTagValue("PRDLST_CD_NM",elem));
            vo.setSs_lcns_no(getTagValue("LCNS_NO",elem));
            
            service.insertSellStop(vo);

              
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
    @GetMapping("/api/SellStop/list")
    public Map<String, Object> selectSellStop_topList(){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<SellStopVO> list = service.selectSellStop_topList();
        resultMap.put("list", list);

        return resultMap;
    }
}
