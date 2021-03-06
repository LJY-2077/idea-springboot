package com.cn.dg.mapper.system;

import com.cn.dg.bean.system.DgSysRolePermission;
import com.cn.dg.bean.system.DgSysRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DgSysRolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    long countByExample(DgSysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    int deleteByExample(DgSysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    int insert(DgSysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    int insertSelective(DgSysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    List<DgSysRolePermission> selectByExample(DgSysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    DgSysRolePermission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    int updateByExampleSelective(@Param("record") DgSysRolePermission record, @Param("example") DgSysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    int updateByExample(@Param("record") DgSysRolePermission record, @Param("example") DgSysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    int updateByPrimaryKeySelective(DgSysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role_permission
     *
     * @mbg.generated 2020-06-22
     */
    int updateByPrimaryKey(DgSysRolePermission record);
}