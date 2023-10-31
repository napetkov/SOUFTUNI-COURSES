package org.softuni.pathfinder.service.impl;

import org.softuni.pathfinder.models.Role;
import org.softuni.pathfinder.models.enums.UserRoles;
import org.softuni.pathfinder.reposritory.RoleRepository;
import org.softuni.pathfinder.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(UserRoles.valueOf(name));
    }
}
