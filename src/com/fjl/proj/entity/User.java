package com.fjl.proj.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 1.性别分布
 * 2.粉丝排行（影响力
 * 3.创作者分布
 * @author Administrator
 *
 */
@Setter
@Getter
@ToString
@Entity
@Table(name="user")
public class User {
	@Id
	private String id;
	@Column
	private String urlToken;
	@Column
	private Integer answers;
	@Column
	private Integer asks;
	@Column
	private Integer articles;
	@Column
	private Integer columns;
	@Column
	private Integer pins;
	@Column
	private Integer incAnswers;
	@Column
	private Integer incPosts;
	@Column
	private Integer agrees;
	@Column
	private Integer thanks;
	@Column
	private Integer collections;
	@Column
	private Integer renke;
	@Column
	private Integer logs;
	@Column
	private Integer followers;
	@Column
	private String gender;
	@Column
	private String headline;
	@Column
	private String name;
	@Column
	//org people
	private String userType;
}
