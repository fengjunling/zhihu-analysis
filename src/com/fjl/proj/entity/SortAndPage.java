package com.fjl.proj.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortAndPage {
	private String prop;
	private String order;
	private Integer currentPage;
}
