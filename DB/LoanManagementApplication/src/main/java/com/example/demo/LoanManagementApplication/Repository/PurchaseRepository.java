package com.example.demo.LoanManagementApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.LoanManagementApplication.Model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
		@Query("select t from Purchase t where t.employee =:cid")
		public List<Purchase> findall(long cid);
}
