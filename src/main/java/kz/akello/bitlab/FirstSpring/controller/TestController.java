package kz.akello.bitlab.FirstSpring.controller;

import kz.akello.bitlab.FirstSpring.beans.TestA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private TestA testA;

    @GetMapping(value = "/test-b")
    public String testB(Model model){
        model.addAttribute("testA", testA);
        return "test";
    }

    @GetMapping(value = "/change-test-b")
    public String changeB(Model model){
        testA.setName("Aqyl");
        testA.setPrice(7777);
        model.addAttribute("testA", testA);
        return "redirect:/test-b";
    }
}
