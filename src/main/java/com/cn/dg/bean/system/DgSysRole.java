package com.cn.dg.bean.system;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table dg_sys_role
 */
public class DgSysRole implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dg_sys_role.roleId
     *
     * @mbg.generated 2020-06-20
     */
    private Integer roleid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dg_sys_role.available
     *
     * @mbg.generated 2020-06-20
     */
    private Boolean available;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dg_sys_role.description
     *
     * @mbg.generated 2020-06-20
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dg_sys_role.role
     *
     * @mbg.generated 2020-06-20
     */
    private String role;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dg_sys_role.roleId
     *
     * @return the value of dg_sys_role.roleId
     *
     * @mbg.generated 2020-06-20
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dg_sys_role.roleId
     *
     * @param roleid the value for dg_sys_role.roleId
     *
     * @mbg.generated 2020-06-20
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dg_sys_role.available
     *
     * @return the value of dg_sys_role.available
     *
     * @mbg.generated 2020-06-20
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dg_sys_role.available
     *
     * @param available the value for dg_sys_role.available
     *
     * @mbg.generated 2020-06-20
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dg_sys_role.description
     *
     * @return the value of dg_sys_role.description
     *
     * @mbg.generated 2020-06-20
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dg_sys_role.description
     *
     * @param description the value for dg_sys_role.description
     *
     * @mbg.generated 2020-06-20
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dg_sys_role.role
     *
     * @return the value of dg_sys_role.role
     *
     * @mbg.generated 2020-06-20
     */
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dg_sys_role.role
     *
     * @param role the value for dg_sys_role.role
     *
     * @mbg.generated 2020-06-20
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleid=").append(roleid);
        sb.append(", available=").append(available);
        sb.append(", description=").append(description);
        sb.append(", role=").append(role);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}