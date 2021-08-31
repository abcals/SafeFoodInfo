package SafeFoodInfo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import SafeFoodInfo.service.ChildInfoService;
import SafeFoodInfo.vo.child_vo.ChildFavoriteFoodQualityVO;


@Controller
public class MainController {
    @Autowired
    ChildInfoService service;

    @GetMapping("/")
    public String getMain(Model model){
        
        return "/index";
    }
    @GetMapping("/test")
    public String getTest(){

        return "/list/test";
    }
    @GetMapping("/result")
    public String getResult(){

        return "/list/result";
    }
    @GetMapping("/stop")
    public String getStop(){

        return "/list/stop";
    }
    @GetMapping("/foodinfo")
    public String getFoodInfo(){

        return "/foodinfo/foodinfo";
    }
    @GetMapping("/healthfoodinfo")
    public String getHealthFoodInfo(){

        return "/healthfoodinfo/healthfoodinfo";
    }
    @GetMapping("/foodadditives")
    public String getFoodAdditives(){

        return "/foodadditives/foodadditives";
    }
    @GetMapping("/board")
    public String getFoodPoison(){

        return "/board/board_main";
    }
    @GetMapping("/child_info")
    public String getChildInfo(){

        return "/child_info/child_info";
    }
    @GetMapping("/child_goodstore")
    public String getChildGoodStore(){
        
        return "/child_info/child_goodstore";
    }
    @GetMapping("/child_mealservice")
    public String getChildMealService(){

        return "/child_info/child_mealservice";
    }
    @GetMapping("/child_favorite")
    public String getChildFavorite(Model model){

       List<ChildFavoriteFoodQualityVO> e_list = service.selectFavoriteE_name();
       model.addAttribute("list", e_list);  
        
        
        return "/child_info/child_favorite";
    }
}
