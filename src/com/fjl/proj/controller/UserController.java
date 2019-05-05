package com.fjl.proj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fjl.proj.dao.UserDao;
import com.fjl.proj.entity.Result;
import com.fjl.proj.entity.SortAndPage;
import com.fjl.proj.entity.User;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	/**
	 * �û�����
	 * @param count
	 * @return
	 */
	@RequestMapping("total")
	public long getTotal() {
		return userDao.count();
	}
	
	/**
	 * �û���Ů�ֲ�
	 * @param count
	 * @return
	 */
	@RequestMapping("gender")
	public List<Long> gender() {
		return userDao.findUserGroupByGender();
	}

	/**
	 * ��˿ǰ20���û�
	 * @param count
	 * @return
	 */
	@RequestMapping("top20")
	public List<User> getTop20() {
		return userDao.findTop20ByOrderByFollowersDesc();
	}
	
	/**
	 * ��˿ǰ20���û�
	 * @param count
	 * @return
	 */
	@RequestMapping("articleAsc20")
	public List<Object> getArticleAsc20() {
		return userDao.findCountGroupByArticles();
	}

	/**
	 * ����ָ��������
	 * @param count
	 * @return
	 */
	@RequestMapping("page")
	public List<User> getPage30(SortAndPage sPage) {
		int page = 0;
		if (sPage.getCurrentPage() != null) {
			page = sPage.getCurrentPage()-1;
		}
		Sort sort = new Sort(Sort.Direction.DESC, sPage.getProp());
		if("descending".equals(sPage.getOrder())){
			return userDao.findAll(PageRequest.of(page, 30, sort)).getContent();
		}else {
			sort = new Sort(Sort.Direction.ASC, sPage.getProp());
			return userDao.findAll(PageRequest.of(page, 30, sort)).getContent();
		}
	}
	
}
