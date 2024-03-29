package org.softuni.pathfinder.reposritory;

import org.softuni.pathfinder.models.Role;
import org.softuni.pathfinder.models.enums.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(UserRoles userRoles);
}
