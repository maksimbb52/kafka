//package com.example.consumer.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//public class MainController {
//
//    // этот метод будет слушать запросы на "/" и "/index"
//    @GetMapping(value = {"/", "/index"})
//    public String index() {
//        return "/index";
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return "/admin";
//    }
//
//    @GetMapping("/user")
//    public String user() {
//        return "/user";
//    }
//
//    @GetMapping("/about")
//    public String about() {
//        return "/about";
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "/login";
//    }
//
//    @GetMapping("/403")
//    public String error403() {
//        return "/error/403";
//    }
//}
