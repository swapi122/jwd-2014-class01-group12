package vn.edu.hcmute.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "concept")
public class Concept {
	
	@Id
	@GeneratedValue
	@Column(name = "ConceptID")
	private long conceptID;
	
	@Column(name = "ConceptName", nullable = false)
	private String conceptName;
	
	@Column(name = "Document")
	private String document;
	
	@ManyToOne
	@JoinColumn(name = "ConceptMapID", nullable = false)
	private ConceptMap conceptMap;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "concept")
	private Set<Feedback> feedback;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "concept1")
	private Set<Relation> relation1;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "concept2")
	private Set<Relation> relation2;
	
	public ConceptMap getConceptMap() {
		return conceptMap;
	}
	public void setConceptMap(ConceptMap conceptMap) {
		this.conceptMap = conceptMap;
	}
	public Set<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}
	public Set<Relation> getRelation1() {
		return relation1;
	}
	public void setRelation1(Set<Relation> relation1) {
		this.relation1 = relation1;
	}
	public Set<Relation> getRelation2() {
		return relation2;
	}
	public void setRelation2(Set<Relation> relation2) {
		this.relation2 = relation2;
	}
	public long getConceptID() {
		return conceptID;
	}
	public void setConceptID(long conceptID) {
		this.conceptID = conceptID;
	}
	public String getConceptName() {
		return conceptName;
	}
	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
}
