package com.my.dao;

import com.my.model.Config;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *  配置类DAO
 */
public interface ConfigDao extends PagingAndSortingRepository<Config, Long> {
	Config findByName(String name);

	@Query(value = "select t from Config t where t.name like %?1% or t.value like %?1% or t.description like %?1%", nativeQuery = false)
	Page<Config> findAllByKeyword(String keyword, Pageable pageable);
}