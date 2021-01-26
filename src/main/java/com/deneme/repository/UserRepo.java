package com.deneme.repository;

<<<<<<< HEAD
=======
import com.deneme.model.Order;
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
import com.deneme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "select u.userId FROM User u WHERE u.username = :username AND u.password = :password")
    long findLoginUser(@Param("username") String username, @Param("password") String password);

    @Query(value = "select u.userId FROM User u WHERE u.username = :username AND u.password = :password")
    long getLoginUserId(@Param("username") String username, @Param("password") String password);
=======
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value = "select u.userId FROM User u WHERE u.username = :username AND u.password = :password")
    long findLoginUser(@Param("username") String username,@Param("password") String password);

    @Query(value = "select u.userId FROM User u WHERE u.username = :username AND u.password = :password")
    long getLoginUserId(@Param("username") String username,@Param("password") String password);
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f

    @Query(value = "FROM User u WHERE u.userId = :userId")
    List<User> getUserById(@Param("userId") long id);

<<<<<<< HEAD
=======

>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
}
