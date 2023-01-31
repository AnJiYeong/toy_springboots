package com.toy.toy_springboots.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.toy.toy_springboots.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @RequestMapping(value = {"/list", "/", ""}, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        Object resultMap = userService.getList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("user/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/listPagination/{currentPage}"}, method = RequestMethod.GET)
    public ModelAndView listPagination(@RequestParam Map<String, Object> params, ModelAndView modelAndView
            , @PathVariable String currentPage) {
        params.put("currentPage", Integer.parseInt(currentPage));
        params.put("pageScale", 10);
        Object resultMap = userService.getListWithPagination(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("user/list_pagination");
        return modelAndView;
    }
}