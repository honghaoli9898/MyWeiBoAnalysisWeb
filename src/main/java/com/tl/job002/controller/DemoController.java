package com.tl.job002.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	@RequestMapping("/")
	@ResponseBody
	String index() {
		return "Hello World天亮教育";
	}

	@RequestMapping("/weibo")
	String weibo() {
		return "weibo";
	}

	@RequestMapping("/dynamic")
	String dynamic() {
		return "dynamic";
	}

	@RequestMapping("/dynamic_v2")
	String dynamic(ModelMap map, String nickname) {
		map.put("nickname", nickname);
		return "dynamic";
	}

	@RequestMapping("/dynamic_v3")
	String dynamic_v3(ModelMap map, String test) {
		try{
		List<Map<String, Object>> s=getHotWordsListTest(test);
		map.put("test", s.toString());
		}catch(Exception e){
			System.out.println("参数错误");
		}
		return "dynamic";
	}

	public List<Map<String, Object>> getHotWordsListTest(String test) {
		String sql = "select freq from weibo_hot_words where word = '"+test+"'";
		System.out.println(sql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
}
