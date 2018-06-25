package com.black.service.serviceimpl;

import com.black.mapper.FctOrderMapper;
import com.black.model.FctOrder;
import com.black.service.FctOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FctOrderServiceImpl implements FctOrderService {
    @Autowired
    private FctOrderMapper fctOrderMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return fctOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FctOrder record) {
        return fctOrderMapper.insert(record);
    }

    @Override
    public FctOrder selectByPrimaryKey(Long id) {
        return fctOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FctOrder> selectAll() {
        return fctOrderMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(FctOrder record) {
        return fctOrderMapper.updateByPrimaryKey(record);
    }
}
