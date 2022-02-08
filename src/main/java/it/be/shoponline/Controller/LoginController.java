package it.be.shoponline.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String getServerStatus() {
        return "Server Online!";
    }

}

