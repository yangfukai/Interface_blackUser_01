package com.black.mapper;

import com.black.model.FctCustomercontract;

import java.util.List;

public interface FctCustomercontractMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_customercontract
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_customercontract
     *
     * @mbggenerated
     */
    int insert(FctCustomercontract record);

    int insertList(List<FctCustomercontract> list);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_customercontract
     *
     * @mbggenerated
     */
    FctCustomercontract selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_customercontract
     *
     * @mbggenerated
     */
    List<FctCustomercontract> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_customercontract
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FctCustomercontract record);
}