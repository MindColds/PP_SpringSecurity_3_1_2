package com.example.pp_springsecurity_3_1_2.service;

import com.example.pp_springsecurity_3_1_2.model.Role;
import com.example.pp_springsecurity_3_1_2.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }

}
