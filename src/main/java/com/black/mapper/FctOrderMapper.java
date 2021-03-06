package com.black.mapper;

import com.black.model.FctOrder;
import com.black.model.FctOrderPage;

import java.util.List;

public interface FctOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_order
     *
     * @mbggenerated
     */
    int insert(FctOrder record);

    int insertList(List<FctOrder> list);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_order
     *
     * @mbggenerated
     */
    FctOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_order
     *
     * @mbggenerated
     */
    List<FctOrder> selectAll();
    List<FctOrder> selectAllPage(FctOrderPage fctOrderPage);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fct_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FctOrder record);

    int selectCount(FctOrderPage fctOrderPage);
}