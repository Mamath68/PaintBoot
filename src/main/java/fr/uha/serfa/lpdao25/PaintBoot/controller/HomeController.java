package fr.uha.serfa.lpdao25.PaintBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public HomeController() {
        System.err.println("HELLO WORLD A DEMARRE");
    }

    @GetMapping("/")
    public String hello() {
        return "<h1>Hello world</h1>";
    }
}
