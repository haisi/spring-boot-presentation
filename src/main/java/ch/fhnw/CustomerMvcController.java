package ch.fhnw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerMvcController {

    @Autowired
    CustomerRepo repo;

    @RequestMapping("/index.php")
    String reservations(Model model) {
        model.addAttribute("customers", repo.findAll());

        return "index";
    }

}
