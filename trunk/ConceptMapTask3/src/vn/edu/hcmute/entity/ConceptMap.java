package vn.edu.hcmute.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "conceptmap")
public class ConceptMap {
	
	@Id
	@GeneratedValue
	@Column(name = "ConceptMapID")
	private long conceptMapID;
	
	@Column(name = "CreateDate")
	private Date createDate;
	
	@Column(name = "SubmitDate")
	private Date submitDate;
	
	@Column(name = "Submited")
	private boolean submited;
	
	@Column(name = "Comments")
	private String comments;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "conceptMap")
	private Assignment assignment;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "conceptMap")
	private StudentAnswer studentanswer;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conceptMap")
	private Set<Shared> shareds;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conceptMap")
	private Set<Concept> concept;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conceptMap")
	private Set<Feedback> feedback;
	
	public Set<Shared> getShareds() {
		return shareds;
	}
	public void setShareds(Set<Shared> shareds) {
		this.shareds = shareds;
	}
	public Set<Concept> getConcept() {
		return concept;
	}
	public void setConcept(Set<Concept> concept) {
		this.concept = concept;
	}
	public Set<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public StudentAnswer getStudentanswer() {
		return studentanswer;
	}
	public void setStudentanswer(StudentAnswer studentanswer) {
		this.studentanswer = studentanswer;
	}
	public long getConceptMapID() {
		return conceptMapID;
	}
	public void setConceptMapID(int conceptMapID) {
		this.conceptMapID = conceptMapID;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public boolean isSubmited() {
		return submited;
	}
	public void setSubmited(boolean submited) {
		this.submited = submited;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
