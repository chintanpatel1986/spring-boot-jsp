package org.chintanpatel.springbootjsp.controller;

import jakarta.validation.Valid;
import org.chintanpatel.springbootjsp.model.Role;
import org.chintanpatel.springbootjsp.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles/getRole")
    public String getRole(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("roleList", roleService.getAllRoleList());
        return "role-form";
    }

    @PostMapping("/roles/saveRole")
    public String saveRole(@Valid @ModelAttribute("role")Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleList", roleService.getAllRoleList());
            return "role-form";
        }
        roleService.addRole(role);
        return "redirect:/roles/getRole";
    }

    @GetMapping("/roles/manageRole")
    public String manageRole(@RequestParam("roleId")Long roleId, Model model) {
        if (roleId != null) {
            model.addAttribute("role", roleService.getRoleById(roleId));
            model.addAttribute("roleList", roleService.getAllRoleList());
        }
        return "role-form";
    }


    @GetMapping("/roles/deleteRole")
    public String deleteRole(@RequestParam("roleId")Long roleId) {
        if (roleId != null) {
            roleService.deleteRoleById(roleId);
        }
        return "redirect:/roles/getRole";
    }
}
