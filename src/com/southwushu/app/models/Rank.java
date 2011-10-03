package com.southwushu.app.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ranks")
public class Rank {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name="person_ranks")
	private List<Person> students;
	
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
}
