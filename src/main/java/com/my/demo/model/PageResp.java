package com.my.demo.model;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 分页响应对象
 */
@Data
public class PageResp<T> {
	private List<T> rows;

	private int page;

	private int pagesize;

	private long total;

	public PageResp(Page<T> page) {
		this.rows = page.getContent();
		this.page = page.getNumber() + 1;
		this.pagesize = page.getSize();
		this.total = page.getTotalElements();
	}

}
