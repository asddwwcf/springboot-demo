package com.my.dao;

import com.my.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 用户DAO
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> {

	User findByName(String username);
}