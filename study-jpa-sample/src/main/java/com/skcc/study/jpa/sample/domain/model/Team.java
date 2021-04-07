package com.skcc.study.jpa.sample.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity
public class Team {
  
  @Id @GeneratedValue
  @javax.persistence.Column(name = "TEAM_ID")
  private Long id;
  
  @javax.persistence.Column(name = "NAME")
  private String name;
  
  @OneToMany(mappedBy = "team")
  private java.util.List<Member> members;
  
  @Builder
  public Team(String name) {
    this.name = name;
  }
  
  //양방향 연관 관계 편의 메소드
  //Member.changeTeam 메소드와 같이 쓰지 않는다.
//  public void addMember(Member member) {
//    member.setTeam(this);
//    this.members.add(member);
//  }
  
}