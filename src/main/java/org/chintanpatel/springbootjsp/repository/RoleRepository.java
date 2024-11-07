package org.chintanpatel.springbootjsp.repository;

import org.chintanpatel.springbootjsp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
}