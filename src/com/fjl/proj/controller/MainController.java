package com.fjl.proj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fjl.proj.dao.TopicDao;
import com.fjl.proj.dao.UserDao;


@CrossOrigin
@RestController
public class MainController{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TopicDao topicDao;
	
	@RequestMapping("list")
	public Map<String, String> list() {
		// 总数 机构号 话题精华>1000
		long totalTopic = topicDao.count();
		long totalUser = userDao.count();
		int than1000 = topicDao.countGT1000();
		int orgNum = userDao.findOrgNum();
		
		Map<String, String> map = new HashMap<String, String>();		
		map.put("totalTopic",String.valueOf(totalTopic));
		map.put("totalUser",String.valueOf(totalUser));
		map.put("than1000",String.valueOf(than1000));
		map.put("orgNum",String.valueOf(orgNum));
		return map;
	}
	
}
