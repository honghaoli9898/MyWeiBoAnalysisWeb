package com.tl.job002.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DBController {
	@Autowired
	private WeiBoDBManager weiBoDBManager;
	@RequestMapping("/hotwords")
	String getHotWords(ModelMap map){
		List<Map<String,Object>> list=weiBoDBManager.getHotWordsList();
		map.put("result", list);
		return "weibo_hotwords";
	}
   
}
