package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Bem-vindo!";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Área de Administração";
    }

    @GetMapping("/tasks")
    @ResponseBody
    public String tasks() {
        return "Área de Tarefas";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}