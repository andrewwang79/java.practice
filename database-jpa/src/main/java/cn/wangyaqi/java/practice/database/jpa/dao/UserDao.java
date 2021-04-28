package cn.wangyaqi.java.practice.database.jpa.dao;

import cn.wangyaqi.java.practice.database.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Integer> {

  @Query(value = "select * from user where name= ?1" , nativeQuery = true)
  User findByName(String name);
}