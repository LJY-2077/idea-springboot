package com.cn.dg.mapper.system;

import com.cn.dg.bean.system.DgSysUserRole;
import com.cn.dg.bean.system.DgSysUserRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DgSysUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    long countByExample(DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    int deleteByExample(DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    int insert(DgSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    int insertSelective(DgSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    List<DgSysUserRole> selectByExample(DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    DgSysUserRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    int updateByExampleSelective(@Param("record") DgSysUserRole record, @Param("example") DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    int updateByExample(@Param("record") DgSysUserRole record, @Param("example") DgSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    int updateByPrimaryKeySelective(DgSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_user_role
     *
     * @mbg.generated 2020-06-20
     */
    int updateByPrimaryKey(DgSysUserRole record);
}