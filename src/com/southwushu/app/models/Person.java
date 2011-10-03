package com.southwushu.app.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name="person.find_all",
			    query="SELECT p FROM Person p"),
	@NamedQuery(name="person.find_by_id",
				query="SELECT p FROM Person p WHERE p.id = :id"),
	@NamedQuery(name="person.find_coach_by_team",
				query="SELECT p FROM Person p WHERE p.team = :id AND p.coach is null")
})

@Entity
@Table(name="persons")
public class Person {
	
	public static final String GET_ALL = "person.find_all";
	public static final String GET_BY_ID = "person.find_by_id";
	public static final String GET_COACH_BY_TEAM = "person.find_coach_by_team";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="middle_name")
	private String middleName;
	
	@Basic @Enumerated(EnumType.STRING)
    private Gender gender;
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	@Temporal(TemporalType.DATE)
	private Date hiredate;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name="coach_id")
	private Person coach;
	
	private Boolean iscoach;
	

	@OneToMany(mappedBy="coach")
	private List<Person> students;
	
	private String identitydoc;
	private String medicaldoc;
	private String wushudoc;
	private String address;
	private String comment;
	
	@ManyToMany
	@JoinTable(name="person_ranks",
			   joinColumns=@JoinColumn(name="person_id", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="rank_id", referencedColumnName="id")
			  )
	private List<Rank> ranks;
	
	@ManyToMany
	@JoinTable(name="person_attachments",
			   joinColumns=@JoinColumn(name="person_id", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="attachment_id", referencedColumnName="id")
			  )
	private List<Attachment> attachments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Person getCoach() {
		return coach;
	}

	public void setCoach(Person coach) {
		this.coach = coach;
	}

	public List<Person> getStudents() {
		return students;
	}

	public void setStudents(List<Person> students) {
		this.students = students;
	}

	public String getIdentitydoc() {
		return identitydoc;
	}

	public void setIdentitydoc(String identitydoc) {
		this.identitydoc = identitydoc;
	}

	public String getMedicaldoc() {
		return medicaldoc;
	}

	public void setMedicaldoc(String medicaldoc) {
		this.medicaldoc = medicaldoc;
	}

	public String getWushudoc() {
		return wushudoc;
	}

	public void setWushudoc(String wushudoc) {
		this.wushudoc = wushudoc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Rank> getRanks() {
		return ranks;
	}

	public void setRanks(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	public Boolean isCoach() {
		return iscoach;
	}
	
	public void setIsCoach(Boolean iscoach) {
		this.iscoach = iscoach;
	}
	
}
