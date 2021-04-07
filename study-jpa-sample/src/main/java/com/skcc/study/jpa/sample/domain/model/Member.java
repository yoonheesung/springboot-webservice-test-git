package com.skcc.study.jpa.sample.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.joda.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member {


	  @Id @GeneratedValue
	  private Long id;
	  private String name;
	  private LocalDate birth;
	  
	  @ManyToOne
	  @JoinColumn(name = "TEAM_ID")
	  private Team team;
	  
	  @OneToOne
	  @JoinColumn(name = "LOCKER_ID")
	  private Locker locker;
	  
	  @OneToMany(mappedBy = "member")
	  private List<MemberProduct> memberProducts = new ArrayList<MemberProduct>();

//    이렇게하면 안 된다는 Case
//	  @ManyToMany 
//	  @JoinTable(name = "MEMBER_PRODUCT")
//	  private List<Product> products = new ArrayList<Product>();
	  
	  
	  @Builder
	  public Member(String name, Team team, LocalDate birth) {
	    this.name = name;
//	    changeTeam(team);
	    this.birth = birth;
	  }
	  
	  //연관관계 편의 메소드
	  //Team.addMember와 같이 사용하지 않는다. - 무한루프될 수 도 있음
	  //public void changeTeam(Team team) {
	  //  this.team = team;
	  //  team.getMembers().add(this);
	  //}

}
