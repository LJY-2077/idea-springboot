package com.cn.dg.mapper.system;

import com.cn.dg.bean.system.DgSysPermission;
import com.cn.dg.bean.system.DgSysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DgSysPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    long countByExample(DgSysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    int deleteByExample(DgSysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    int deleteByPrimaryKey(Integer permissionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    int insert(DgSysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    int insertSelective(DgSysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    List<DgSysPermission> selectByExample(DgSysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    DgSysPermission selectByPrimaryKey(Integer permissionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    int updateByExampleSelective(@Param("record") DgSysPermission record, @Param("example") DgSysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    int updateByExample(@Param("record") DgSysPermission record, @Param("example") DgSysPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    int updateByPrimaryKeySelective(DgSysPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_permission
     *
     * @mbg.generated 2020-06-22
     */
    int updateByPrimaryKey(DgSysPermission record);
}