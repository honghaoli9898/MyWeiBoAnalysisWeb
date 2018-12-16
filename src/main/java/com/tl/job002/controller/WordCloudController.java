package com.tl.job002.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;

@Controller
public class WordCloudController {
	@Autowired
	private WeiBoDBManager weiBoDBManager;
	@RequestMapping("/wordcloud_original")
	String getHotWordsOriginal(ModelMap map){
		return "wordcloud_original";
	}
	 @RequestMapping("/wordcloud")
	    String getHotWords(ModelMap modelMap) {
	        JSONArray jsonArray = weiBoDBManager.getHotWordsJsonArray();
	        modelMap.put("result", jsonArray.toJSONString());
	        return "wordcloud";
	    }
}
