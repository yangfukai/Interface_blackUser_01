package com.black.mapper;

import com.black.model.FctCase;
import java.util.List;

public interface FctCaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_case
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_case
     *
     * @mbggenerated
     */
    int insert(FctCase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_case
     *
     * @mbggenerated
     */
    FctCase selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_case
     *
     * @mbggenerated
     */
    List<FctCase> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_case
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FctCase record);
}