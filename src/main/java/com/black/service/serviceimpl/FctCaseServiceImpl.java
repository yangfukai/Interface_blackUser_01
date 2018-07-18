package com.black.service.serviceimpl;

import com.black.mapper.FctCaseMapper;
import com.black.model.FctCase;
import com.black.service.FctCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FctCaseServiceImpl implements FctCaseService {

    @Autowired
    private FctCaseMapper fctCaseMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return fctCaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FctCase record) {
        return fctCaseMapper.insert(record);
    }

    @Override
    public int insertList(List<FctCase> list) {
        return fctCaseMapper.insertList(list);
    }

    @Override
    public FctCase selectByPrimaryKey(Long id) {
        return fctCaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FctCase> selectAll() {
        return fctCaseMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(FctCase record) {
        return fctCaseMapper.updateByPrimaryKey(record);
    }
}
