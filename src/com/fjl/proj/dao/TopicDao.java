package com.fjl.proj.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fjl.proj.entity.Topic;

public interface TopicDao extends JpaRepository<Topic, Integer> {

	public List<Topic> findTop20ByOrderByFollowersDesc();

	@Query(value = "SELECT count(1) from Topic where bestAnswersCount >= 1000")
	public int countGT1000();

	@Query("SELECT t FROM Topic t order by ?1 desc")
	public Page<Topic> findTop30ByOrderByParam(String param, Pageable pageable);

	public Topic findByToken(String token);

	public List<Topic> findByParent(String parent);
}
