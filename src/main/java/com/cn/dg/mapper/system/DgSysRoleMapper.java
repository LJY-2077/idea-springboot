package com.cn.dg.mapper.system;

import com.cn.dg.bean.system.DgSysRole;
import com.cn.dg.bean.system.DgSysRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DgSysRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    long countByExample(DgSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    int deleteByExample(DgSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    int deleteByPrimaryKey(Integer roleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    int insert(DgSysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    int insertSelective(DgSysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    List<DgSysRole> selectByExample(DgSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    DgSysRole selectByPrimaryKey(Integer roleid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    int updateByExampleSelective(@Param("record") DgSysRole record, @Param("example") DgSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    int updateByExample(@Param("record") DgSysRole record, @Param("example") DgSysRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    int updateByPrimaryKeySelective(DgSysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dg_sys_role
     *
     * @mbg.generated 2020-06-20
     */
    int updateByPrimaryKey(DgSysRole record);
}