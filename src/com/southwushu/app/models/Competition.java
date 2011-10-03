package com.southwushu.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="competitions")
public class Competition {
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name="competition_participants",
			   joinColumns=@JoinColumn(name="competition_id", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="person_id", referencedColumnName="id")
			  )
	private List<Person> students;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Person> getStudents() {
		return students;
	}
	public void setStudents(List<Person> students) {
		this.students = students;
	}
	
}
