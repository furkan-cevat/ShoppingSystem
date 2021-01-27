package com.deneme.repository;

import com.deneme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.userId FROM User u WHERE u.username = :username AND u.password = :password")
    long findLoginUser(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT u.userId FROM User u WHERE u.username = :username AND u.password = :password")
    long getLoginUserId(@Param("username") String username, @Param("password") String password);

    @Query(value = "FROM User u WHERE u.userId = :userId")
    List<User> getUserById(@Param("userId") long id);

}
