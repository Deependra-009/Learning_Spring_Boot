package com.security.trustshield.Repository;

import com.security.trustshield.Modals.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

        public Optional<User> findByEmail(String email);

}
