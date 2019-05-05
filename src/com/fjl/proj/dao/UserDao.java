package com.fjl.proj.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fjl.proj.entity.Result;
import com.fjl.proj.entity.User;

public interface UserDao extends JpaRepository<User, String>{

	public List<User> findTop20ByOrderByFollowersDesc();
	
	@Query("select count(1) from User where userType='organization'")
	public int findOrgNum();
	
	@Query("SELECT count(1) FROM User u group by u.gender order by u.gender")
	public List<Long> findUserGroupByGender();
	
	@Query(value="SELECT count(1) as uCount,u.articles as aCount FROM User u group by u.articles order by u.articles limit 20",nativeQuery=true)
	public List<Object> findCountGroupByArticles();
}
