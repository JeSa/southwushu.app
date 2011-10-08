package com.southwushu.app.models;

import java.util.List;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name="team.find_all",
			    query="SELECT t FROM Team t"),
	@NamedQuery(name="team.find_by_id",
				query="SELECT t FROM Team t WHERE t.id = :id"),
})

@Entity
@Table(name="teams")
public class Team {
	
	public static final String GET_ALL = "team.find_all";
	public static final String GET_BY_ID = "team.find_by_id";
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String city;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

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
