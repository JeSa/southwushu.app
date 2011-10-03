package com.southwushu.app.models;

import javax.persistence.*;

@Entity
@Table(name="participant_categories")
public class ParticipantCategory {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	@Basic @Enumerated(EnumType.STRING)
	private Gender gender;
	private Double startweight;
	private Double endweight;
	private Integer startage;
	private Integer endage;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Double getStartweight() {
		return startweight;
	}
	public void setStartweight(Double startweight) {
		this.startweight = startweight;
	}
	public Double getEndweight() {
		return endweight;
	}
	public void setEndweight(Double endweight) {
		this.endweight = endweight;
	}
	public Integer getStartage() {
		return startage;
	}
	public void setStartage(Integer startage) {
		this.startage = startage;
	}
	public Integer getEndage() {
		return endage;
	}
	public void setEndage(Integer endage) {
		this.endage = endage;
	}

}
