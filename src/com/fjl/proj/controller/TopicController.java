package com.fjl.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fjl.proj.dao.TopicDao;
import com.fjl.proj.entity.Topic;

@CrossOrigin
@RestController
@RequestMapping("topic")
public class TopicController {

	@Autowired
	private TopicDao topicDao;

	/**
	 * 关注人数前20
	 * 
	 * @param topic
	 * @return
	 */
	@RequestMapping("followers")
	public List<Topic> getTop20ByFollowers() {
		return topicDao.findTop20ByOrderByFollowersDesc();
	}

	/**
	 * 获取与该话题下的子话题
	 * 
	 * @param topic
	 * @return
	 */
	@RequestMapping("relations")
	public List<Topic> getRelations(Topic topic) {
		return topicDao.findByParent(topic.getParent());
	}

	/**
	 * 根据token获取话题信息
	 * 
	 * @param topic
	 * @return
	 */
	@RequestMapping("")
	public Topic getTopic(Topic topic) {
		return topicDao.findByToken(topic.getToken());
	}
}
