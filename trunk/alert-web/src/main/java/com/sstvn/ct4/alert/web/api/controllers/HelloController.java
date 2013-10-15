package com.sstvn.ct4.alert.web.api.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.sstvn.ct4.alert.core.services.HelloService;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
@Controller
public class HelloController {
	@Autowired
	private UrlBasedViewResolver tilesViewResolver;
	
	private Log log = LogFactory.getLog(HelloController.class);  
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/sayhello")
	public  String sayHello(@RequestParam("name") String name) {
//		helloService.sayHello(name);
		return "default";
	}
	
    @RequestMapping("/greeting")
    public void greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model, HttpServletRequest req, HttpServletResponse response) {
        model.addAttribute("name", name);
        log.info("/greeting called");
        View view;
		try {
			view = tilesViewResolver.resolveViewName("taglib/index", null);
			log.info(view);
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", name);
			view.render(map, req, response);
//			log.info(view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("exception caught", e);
		}
        
//        return "taglib/index2";
    }
}
