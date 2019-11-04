package com.example.producer.controller;

import org.springframework.http.MediaType;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ResponseBody
@RequestMapping(value = "/security")
public class SecurityController {

    @GetMapping
    public String getHello() {
        return "Hello";
    }

    @GetMapping(path = "/csrf", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getCsrfToke(HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        String str = "\n";
        str += "\nX-CSRF-TOKEN:";
        str += token.getToken();
        return str;
    }
}
