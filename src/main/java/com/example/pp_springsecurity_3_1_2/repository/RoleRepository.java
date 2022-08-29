package com.example.pp_springsecurity_3_1_2.repository;

import com.example.pp_springsecurity_3_1_2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
