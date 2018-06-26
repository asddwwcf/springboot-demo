package com.my.demo.dao;

import com.my.demo.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 用户DAO
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

	User findByName(String username);
}