package com.skcc.study.jpa.sample.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Product {
	@Id @GeneratedValue
	private Long id;
	
//	
//	@ManyToMany(mappedBy = "member")
//	private List<Member> members = new ArrayList<Member>();
	
    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts = new ArrayList<MemberProduct>();

}
