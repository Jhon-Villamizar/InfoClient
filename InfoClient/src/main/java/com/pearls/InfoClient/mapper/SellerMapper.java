package com.pearls.InfoClient.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearls.InfoClient.model.Seller;
import com.pearls.InfoClient.model.Visit;

@Service("sellerMapper")
public class SellerMapper {
	
	@Autowired
	VisitMapper visitMapper;

	public Set<Seller> mapper(Set<Seller> seller){
		Set<Seller> sellers = new HashSet<Seller>();
		for(Seller se : seller) {
			Seller se2 = mapper(se);
			sellers.add(se2);
		}
		return sellers;
	}
	
	public Seller mapper(Seller se) {
		Seller se2 = new Seller();
		se2.setId(se.getId());
		se2.setName(se.getName());
		se2.setDocument(se.getDocument());

		se.setSellers(se.getSellers());
		
		Set<Visit> v = visitMapper.mapper(se.getSellers());
		se2.setSellers(v);
		return se2;
	}
	
}
