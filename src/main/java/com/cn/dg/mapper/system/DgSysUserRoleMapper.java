package com.cn.dg.mapper.system;

import com.cn.dg.bean.system.DgSysUserRole;
import com.cn.dg.bean.system.DgSysUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DgSysUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    long countByExample(DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    int deleteByExample(DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    int insert(DgSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    int insertSelective(DgSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    List<DgSysUserRole> selectByExample(DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    DgSysUserRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    int updateByExampleSelective(@Param("record") DgSysUserRole record, @Param("example") DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    int updateByExample(@Param("record") DgSysUserRole record, @Param("example") DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    int updateByPrimaryKeySelective(DgSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-22
     */
    int updateByPrimaryKey(DgSysUserRole record);
}