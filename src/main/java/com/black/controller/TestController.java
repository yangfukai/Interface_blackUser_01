package com.black.controller;

import com.alibaba.fastjson.JSONObject;
import com.black.controller.testbean.RetBean;
import com.black.controller.testbean.TestBean;
import com.black.model.FctCase;
import com.black.model.FctOrder;
import com.black.model.FctOrderPage;
import com.black.service.FctCaseService;
import com.black.service.FctOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/testboot")
public class TestController {

    @Autowired
    private FctCaseService fctCaseService;
    @RequestMapping(value = "getfctCase" , produces = {"application/json;charset=UTF-8"})
    public FctCase getUser(long id) {
        FctCase fctCase = fctCaseService.selectByPrimaryKey(id);
        return fctCase;
    }

    @Autowired
    private FctOrderService fctOrderService;
    @GetMapping(value = "test",produces = {"application/json;charset=UTF-8"})
    public RetBean testRet(String draw, int start, int length, HttpServletRequest request) throws ParseException {
        RetBean ret = new RetBean();
        FctOrderPage fctOrderPage = new FctOrderPage();
        fctOrderPage.setStart(start);
        fctOrderPage.setLength(length);
        Map<String,String[]> params = request.getParameterMap();
        Set<String> keys = params.keySet();
        for (String key:keys) {
            if (key.startsWith("columns")) {
                if (key.endsWith("[search][value]")) {
                    String value = params.get(key)[0];
                    if (!"".equals(value)) {
                        String param = params.get(key.replace("[search][value]","[data]"))[0];
                        if("employeename".equals(param)){
                            fctOrderPage.setEmployeename(value);
                        }else if("contractid".equals(param)){
                            fctOrderPage.setContractid(value);
                        }else if("customername".equals(param)){
                            fctOrderPage.setCustomername(value);
                        }else if("idcardnumber".equals(param)){
                            fctOrderPage.setIdcardnumber(value);
                        }else if("bankcardnumber".equals(param)){
                            fctOrderPage.setBankcardnumber(value);
                        }else if("bankname".equals(param)){
                            fctOrderPage.setBankname(value);
                        }else if("storename".equals(param)){
                            fctOrderPage.setStorename(value);
                        }else if("productname".equals(param)){
                            fctOrderPage.setProductname(value);
                        }else if("contractmoney".equals(param)){
                            fctOrderPage.setContractmoney(BigDecimal.valueOf(Double.parseDouble(value)));
                        }else if("alreadyperiods".equals(param)){
                            fctOrderPage.setAlreadyperiods(Integer.parseInt(value));
                        }else if("contractperiods".equals(param)){
                            fctOrderPage.setContractperiods(Integer.parseInt(value));
                        }else if("repaymentstartdate".equals(param)){
                            fctOrderPage.setRepaymentstartdate(DateFormat.getDateInstance().parse(value));
                        }else if("repaymentday".equals(param)){
                            fctOrderPage.setRepaymentday(Integer.parseInt(value));
                        }else if("overduedays".equals(param)){
                            fctOrderPage.setOverduedays(Integer.parseInt(value));
                        }else if("advancemoney".equals(param)){
                            fctOrderPage.setAdvancemoney(BigDecimal.valueOf(Double.parseDouble(value)));
                        }else if("repaymentmoney".equals(param)){
                            fctOrderPage.setRepaymentmoney(BigDecimal.valueOf(Double.parseDouble(value)));
                        }else if("entruststartdate".equals(param)){
                            fctOrderPage.setEntruststartdate(DateFormat.getDateInstance().parse(value));
                        }else if("entrustenddate".equals(param)){
                            fctOrderPage.setEntrustenddate(DateFormat.getDateInstance().parse(value));
                        }else if("entrustcompanyname".equals(param)){
                            fctOrderPage.setEntrustcompanyname(value);
                        }
                    }
                }
            } else if (key.startsWith("order")) {
                if(key.endsWith("[column]")){
                    fctOrderPage.setSortFied(params.get("columns["+params.get(key)[0]+"][data]")[0]);
                }else {
                    fctOrderPage.setSort(params.get(key)[0]);
                }
            }
        }
        List<FctOrder> list = fctOrderService.selectAll(fctOrderPage);
        ret.setDraw(draw);
        int count = fctOrderService.selectCount(fctOrderPage);
        ret.setRecordsFiltered(count);
        ret.setRecordsTotal(count);
        ret.setData(list);
        return ret;
    }
}
