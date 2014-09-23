package vn.edu.hcmute.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "assignment")
public class Assignment {
	
	@Id
	@GeneratedValue
	@Column(name = "AssignmentID")
	private long assignmentID;
	
	@Column(name = "AssignmentName", nullable = false)
	private String assignmentName;
	
	@Column(name = "Requirement", nullable = false)
	private String requirement;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "CreateDate", nullable = false)
	private Date createDate;
	
	@Column(name = "Deadline", nullable = false)
	private Date deadline;
	
	@Column(name = "StartedDate", nullable = false)
	private Date startedDate;
	
	@Column(name = "Published", nullable = false)
	private boolean published;
	
	@Column(name = "MaxMark", nullable = false)
	private double maxMark;
	
	@Column(name = "PassMark", nullable = false)
	private double passMark;
	
	@ManyToOne
	@JoinColumn(name = "UserID", nullable = false)
	private User user;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "ConceptMapID", unique = true, nullable = false)
	private ConceptMap conceptMap;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assignment")
	private Set<Task> tasks;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ConceptMap getConceptMap() {
		return conceptMap;
	}
	public void setConceptMap(ConceptMap conceptMap) {
		this.conceptMap = conceptMap;
	}
	public long getAssignmentID() {
		return assignmentID;
	}
	public void setAssignmentID(long assignmentID) {
		this.assignmentID = assignmentID;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Date getStartedDate() {
		return startedDate;
	}
	public void setStartedDate(Date startedDate) {
		this.startedDate = startedDate;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public double getMaxMark() {
		return maxMark;
	}
	public void setMaxMark(double maxMark) {
		this.maxMark = maxMark;
	}
	public double getPassMark() {
		return passMark;
	}
	public void setPassMark(double passMark) {
		this.passMark = passMark;
	}
}
