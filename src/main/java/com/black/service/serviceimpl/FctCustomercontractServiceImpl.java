package com.black.service.serviceimpl;

import com.black.mapper.FctCustomercontractMapper;
import com.black.model.FctCustomercontract;
import com.black.service.FctCustomercontractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FctCustomercontractServiceImpl implements FctCustomercontractService {

    @Autowired
    private FctCustomercontractMapper fctCustomercontractMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return fctCustomercontractMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FctCustomercontract record) {
        return fctCustomercontractMapper.insert(record);
    }

    @Override
    public int insertList(List<FctCustomercontract> list) {
        return fctCustomercontractMapper.insertList(list);
    }

    @Override
    public FctCustomercontract selectByPrimaryKey(Long id) {
        return fctCustomercontractMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FctCustomercontract> selectAll() {
        return fctCustomercontractMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(FctCustomercontract record) {
        return fctCustomercontractMapper.updateByPrimaryKey(record);
    }
}
