package com.cejgroup.inventorysystem.domain.interfaces.User;

import com.cejgroup.inventorysystem.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
