package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 19.01.2017.
 */
@Controller
public class ClientListController {

    @RequestMapping("/clientList")
    public String userList(){
        return "clientList";
    }
}
