package com.black;

import com.black.model.FctCase;
import com.black.model.FctCustomercontract;
import com.black.model.FctOrder;
import com.black.service.FctCaseService;
import com.black.service.FctCustomercontractService;
import com.black.service.FctOrderService;
import com.black.util.ReadExcelFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class InterfaceBlackUser02ApplicationTests {

	@Autowired
	private FctCaseService fctCaseService;
	@Autowired
	private FctCustomercontractService fctCustomercontractService;
	@Autowired
	private FctOrderService fctOrderService;

//	@Test
	public void contextLoads() throws Exception {
		List<String[]> list = ReadExcelFile.readExcelsXLSX("F:\\WeChatFile\\WeChat Files\\yangkai--123\\Files\\111.xlsx");
		List<FctCase> fctCases = new ArrayList<>(120);
		FctCase fctCase;
		List<FctCustomercontract> fctCustomercontracts = new ArrayList<>(120);
		FctCustomercontract fctCustomercontract;
		List<FctOrder> fctOrders = new ArrayList<>(120);
		FctOrder fctOrder;
		int count  = 0;
		for (String[] ary :list) {
			fctCase = new FctCase();
			fctCustomercontract = new FctCustomercontract();
			fctOrder = new FctOrder();
			fctOrder.setEmployeeid(0+"");
			fctCase.setCustomerid(count+"");
			fctCase.setCaseid(count+"");
			fctCase.setCompanyid(count+"");
			fctCase.setProductid(count+"");
			fctCustomercontract.setCustomerid(count+"");
			fctOrder.setCustomerid(count+"");
			fctOrder.setStoreid(count+"");
			fctOrder.setProductid(count+"");
			count++;
			for (int i = 0; i < ary.length; i++) {
				System.out.print(ary[i] + " ");
				fctCase.setCustomermobilephone("");
				fctCase.setCustomertelphone("");
				fctCase.setOverdueflag(0);
				fctCustomercontract.setCustomermobilephone("");
				fctCustomercontract.setCustomertelphone("");
				fctCustomercontract.setCustomerhomeaddress("");
				fctCustomercontract.setCustomerfamilyaddress("");
				fctCustomercontract.setCustomercompanyaddress("");
				fctCustomercontract.setContractname("");
				fctCustomercontract.setContractrelationship("");
				fctCustomercontract.setContractmobilephone("");
				fctCustomercontract.setRemarks("");
				if(0==i){
					fctOrder.setEmployeename(ary[i]);
				}
				if(1==i){
					fctOrder.setContractid(ary[i]);
				}
				if(2==i){
					//客户姓名
					fctCase.setCustomername(ary[i]);
					fctCustomercontract.setContractname(ary[i]);
					fctOrder.setCustomername(ary[i]);
				}
				if(3==i){
					fctCase.setRemarks(ary[i]);
					fctOrder.setRemarks(ary[i]);
				}
				if(4==i){
					//身份证号
					fctCase.setIdcardnumber(ary[i]);
					fctCustomercontract.setIdcardnumber(ary[i]);
					fctOrder.setIdcardnumber(ary[i]);
				}
				if(5==i){
					//银卡卡号
					fctOrder.setBankcardnumber(ary[i]);
				}
				if(6==i){
					fctOrder.setBankname(ary[i]);
				}
				if(7==i){
					fctOrder.setStorename(ary[i]);
				}
				if (8==i){
					//产品名称
					fctCase.setProductname(ary[i]);
					fctOrder.setProductname(ary[i]);
				}
				if (9==i){
					//借款金额
					fctCase.setContractmoney(BigDecimal.valueOf(Double.parseDouble(ary[i])));
					fctOrder.setContractmoney(BigDecimal.valueOf(Double.parseDouble(ary[i])));
				}
				if(10==i){
					fctOrder.setAlreadyperiods(Integer.parseInt(ary[i]));
				}
				if(11==i){
					fctOrder.setContractperiods(Integer.parseInt(ary[i]));
				}
				if(12==i){
					//借款日期
					fctCase.setContractdate(DateFormat.getDateInstance().parse(ary[i]));
					fctOrder.setRepaymentstartdate(DateFormat.getDateInstance().parse(ary[i]));
				}
				if(13==i){
					fctOrder.setRepaymentday(Integer.parseInt(ary[i]));
				}
				if(14==i){
					//逾期天数
					fctCase.setOverduedays(Integer.parseInt(ary[i]));
					fctOrder.setOverduedays(Integer.parseInt(ary[i]));
				}
				if(15==i){
					fctOrder.setAdvancemoney(BigDecimal.valueOf(Double.parseDouble(ary[i])));
				}
				if(16==i){
					//逾期金额
					fctCase.setOverduemoney(BigDecimal.valueOf(Double.parseDouble(ary[i])));
					fctOrder.setRepaymentmoney(BigDecimal.valueOf(Double.parseDouble(ary[i])));
				}
				if(17==i){
					//逾期开始日期
					fctCase.setOverduestartdate(DateFormat.getDateInstance().parse(ary[i]));
					fctOrder.setRepaymentenddate(DateFormat.getDateInstance().parse(ary[i]));
					fctOrder.setEntruststartdate(DateFormat.getDateInstance().parse(ary[i]));
				}
				if(18==i){
					fctOrder.setEntrustenddate(DateFormat.getDateInstance().parse(ary[i]));
				}
				if(19==i){
					//公司名称
					fctCase.setCompanyname(ary[i]);
					fctOrder.setEntrustcompanyname(ary[i]);
				}

			}
			System.out.println("");
			fctCases.add(fctCase);
			fctCustomercontracts.add(fctCustomercontract);
			fctOrders.add(fctOrder);
		}
		fctCaseService.insertList(fctCases);
		fctCustomercontractService.insertList(fctCustomercontracts);
		fctOrderService.insertList(fctOrders);
	}

}
