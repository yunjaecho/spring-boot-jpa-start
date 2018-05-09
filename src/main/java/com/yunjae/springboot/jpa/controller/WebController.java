package com.yunjae.springboot.jpa.controller;

import com.yunjae.springboot.jpa.domain.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;


@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/")
    //public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, @RequestParam HashMap requestMap) {
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        long size = personForm.getFile().getSize();

        if (bindingResult.hasErrors()) {
            return "form";
        }

        if (size > 1)
            return "form";

        return "redirect:/results";
    }
}