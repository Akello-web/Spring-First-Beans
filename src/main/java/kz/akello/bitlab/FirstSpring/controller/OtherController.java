package kz.akello.bitlab.FirstSpring.controller;

import kz.akello.bitlab.FirstSpring.beans.TestA;
import kz.akello.bitlab.FirstSpring.beans.TestB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @Autowired
    private TestA testA;

    @Autowired
    @Qualifier("testB-two")
    private TestB anyNameforTestB;

    @GetMapping(value = "/test-a")
    public String testA(Model model){
        System.out.println(testA.getName() + " " + testA.getPrice());
        model.addAttribute("testA", testA);

        System.out.println(anyNameforTestB.getCode() + " " + anyNameforTestB.getVolume());
        return "test";
    }
}
