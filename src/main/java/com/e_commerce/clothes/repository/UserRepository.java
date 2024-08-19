package com.e_commerce.clothes.repository;

import com.e_commerce.clothes.domain.entity.user.Role;
import com.e_commerce.clothes.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
//    Optional<User> findByPhoneNumber(String phoneNumber);
    List<User> findByRole(Role role);
    boolean existsByUsername(String username);
}

