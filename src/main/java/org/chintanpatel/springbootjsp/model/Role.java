package org.chintanpatel.springbootjsp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tbl_role_role_id_seq')")
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Size(max = 255)
    @NotEmpty(message = "Please Enter Role Type")
    @Column(name = "role_type", nullable = false)
    private String roleType;

    @OneToMany(mappedBy = "role")
    private Set<Employee> tblEmployees = new LinkedHashSet<>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Set<Employee> getTblEmployees() {
        return tblEmployees;
    }

    public void setTblEmployees(Set<Employee> tblEmployees) {
        this.tblEmployees = tblEmployees;
    }

}