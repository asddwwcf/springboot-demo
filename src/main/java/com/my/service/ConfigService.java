package com.my.service;


import java.util.Collection;
import java.util.List;
import com.my.model.PageResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.google.common.collect.Lists;
import com.my.model.Config;
import com.my.dao.ConfigDao;

/**
 * 配置业务处理类
 */
@Service
public class ConfigService {

	private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

	@Autowired
	ConfigDao dao;

	public Collection<Config> getAll() {
		// 校验通过后打印重要的日志
		logger.info("getAll start ...");

		List<Config> data = Lists.newArrayList(dao.findAll());

		logger.info("getAll end, data size:" + data.size());

		return data;
	}

	public long add(Config config) {

		// 校验通过后打印重要的日志
		logger.info("add config:" + config);
		// 校验重复
		config = dao.save(config);

		// 修改操作需要打印操作结果
		logger.info("add config success, id:" + config.getId());

		return config.getId();
	}

	public boolean delete(long id) {
		// 修改操作需要打印操作结果
		logger.info("delete config success, id:" + id);

		return true;
	}

	public PageResp<Config> listPage(Pageable pageable, String keyword) {
		if (StringUtils.isEmpty(keyword)) {
			return new PageResp<Config>(dao.findAll(pageable));
		}
		else {
			// 也可以用springjpa 的 Specification 来实现查找
			return new PageResp<>(dao.findAllByKeyword(keyword, pageable));
		}
	}
}
