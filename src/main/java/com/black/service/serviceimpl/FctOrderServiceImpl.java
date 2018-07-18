package com.black.service.serviceimpl;

import com.black.mapper.FctOrderMapper;
import com.black.model.FctOrder;
import com.black.model.FctOrderPage;
import com.black.service.FctOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public int insertList(List<FctOrder> list) {
        return fctOrderMapper.insertList(list);
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
    public List<FctOrder> selectAll(FctOrderPage fctOrderPage) {
        List<FctOrder> list = fctOrderMapper.selectAllPage(fctOrderPage);
        return list;
    }

    @Override
    public int updateByPrimaryKey(FctOrder record) {
        return fctOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<FctOrder> selectPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<FctOrder> list = fctOrderMapper.selectAll();
        PageInfo<FctOrder> pageInfo = new PageInfo<FctOrder>(list);
        return pageInfo;
    }

    @Override
    public int selectCount(FctOrderPage fctOrderPage) {
        int i;
        i = fctOrderMapper.selectCount(fctOrderPage);
        return i;
    }
}
