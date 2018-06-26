package com.my.demo.model;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(indexes = { @Index(name = "user_name_unique", columnList = "name", unique = true) })
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	private String nick;

	/**
	 * 角色
	 */
	private String role;

}
