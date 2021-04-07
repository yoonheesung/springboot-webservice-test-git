package com.skcc.study.jpa.sample.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Locker {
  @Id @GeneratedValue
  private Long id;
  
  private String name;

  @Builder
  public Locker(String name) {
    this.name = name;
  }

  //읽기전용됨, 1:1 양방향
  @OneToOne(mappedBy = "locker")
  private Member member;

}
