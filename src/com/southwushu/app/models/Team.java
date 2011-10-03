package com.southwushu.app.models;

import java.util.List;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name="team.find_all",
			    query="SELECT t FROM Team t")
})

@Entity
@Table(name="teams")
public class Team {
	
	public static final String GET_ALL = "team.find_all";
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String city;
	
	@OneToMany(mappedBy="team")
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

	public List<Person> getStudents() {
		return students;
	}

	public void setStudents(List<Person> students) {
		this.students = students;
	}
	
	
}
