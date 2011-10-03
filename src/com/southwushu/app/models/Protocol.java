package com.southwushu.app.models;

public class Protocol {
	private Long id;
	private Person person_one;
	private Person person_two;
	private ParticipantCategory category;
	private Integer level;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Person getPerson_one() {
		return person_one;
	}
	public void setPerson_one(Person person_one) {
		this.person_one = person_one;
	}
	public Person getPerson_two() {
		return person_two;
	}
	public void setPerson_two(Person person_two) {
		this.person_two = person_two;
	}
	public ParticipantCategory getCategory() {
		return category;
	}
	public void setCategory(ParticipantCategory category) {
		this.category = category;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
}
