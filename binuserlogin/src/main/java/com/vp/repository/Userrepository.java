package com.vp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.vp.model.User;

public interface Userrepository extends JpaRepository<User, Integer> {

}
