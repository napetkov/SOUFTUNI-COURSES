package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameOrEmail(String username, String email);

    User findByUsername(String username);
}
