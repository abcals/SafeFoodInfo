package SafeFoodInfo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
  
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
    @GetMapping("/foodcode")
    public String getFoodCode(){

        return "/foodcode/foodcode";
    }
    @GetMapping("/foodpoison")
    public String getFoodPoison(){

        return "/foodpoison/foodpoison";
    }
    @GetMapping("/child_info")
    public String getChildInfo(){

        return "/child_info/child_info";
    }
}
