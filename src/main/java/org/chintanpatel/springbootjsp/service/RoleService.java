package org.chintanpatel.springbootjsp.service;

import org.chintanpatel.springbootjsp.model.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    List<Role>getAllRoleList();

    Role getRoleById(Long roleId);

    void deleteRoleById(Long roleId);
}
