package com.tl.job002.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	@RequestMapping("/")
	@ResponseBody
	String index(){
		return "Hello World天亮教育";
	}
	@RequestMapping("/weibo")
	String weibo(){
		return "weibo";
	}
	@RequestMapping("/dynamic")
	String dynamic(){
		return "dynamic";
	}
	@RequestMapping("/dynamic_v2")
	String dynamic(ModelMap map,String nickname){
		map.put("nickname", nickname);
		return "dynamic";
	}
}
