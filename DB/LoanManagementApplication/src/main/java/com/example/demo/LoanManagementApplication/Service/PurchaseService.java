package com.example.demo.LoanManagementApplication.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.LoanManagementApplication.Model.Purchase;
import com.example.demo.LoanManagementApplication.Repository.PurchaseRepository;

@Service
@Transactional
public class PurchaseService {
	@Autowired
	private PurchaseRepository prepo;
	public  Purchase reg_purchases(Purchase pur) {
		return prepo.save(pur); // invoke jpa repository save() method
	}
	
	public Purchase findby_eid(long cid){
		List<Purchase> li = prepo.findAll();
		Purchase re = new Purchase();
		for(Purchase p:li) {
			long x=p.getEmployee().getEid();
			if(x==cid) {
				re = p;
				break;
			}
		}
		return re;
	}
	public List<Purchase> getAllPurchase()
	{
		return prepo.findAll();
	}
    
	public List<Purchase> findall(long cid) {
		// TODO Auto-generated method stub
		return prepo.findall(cid);
	}
	

}
