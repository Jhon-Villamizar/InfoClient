package com.pearls.InfoClient.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.pearls.InfoClient.model.Visit;

@Service("visitMapper")
public class VisitMapper {

	public Set<Visit> mapper(Set<Visit>visit) {
		Set<Visit> visits = new HashSet<Visit>();
		for (Visit v: visit) {
			Visit  v2 = mapper(v);
			visits.add(v2);
		}
		return visits;
	}
	
	public Visit mapper(Visit v) {
		Visit v2 = new Visit();
		v2.setId(v.getId());
		v2.setDate(v.getDate());
		v2.setSrId(v.getSrId());
		v2.setNet(v.getNet());
		v2.setVisitTotal(v.getVisitTotal());
		v2.setDescription(v.getDescription());
		return v2;
	}
}
