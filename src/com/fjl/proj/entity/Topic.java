package com.fjl.proj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 1.话题关注人数维度分析 关注着前十
 * 2.话题关系图
 * 3.话题讨论热度分析 讨论热度前十
 * @author Administrator
 *
 */

@Setter
@Getter
@ToString
@Entity
@Table(name="topic")
public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String token;
	@Column
	private String name;
	@Column
	private String url;
	/*@Column
	private String description;*/
	@Column
	private String parent;
	@Column
	private Integer followers;
	@Column
	private Integer bestAnswersCount;
	@Column
	private Integer unAnsweredCount;
	@Column
	private Integer questions;
	
}
