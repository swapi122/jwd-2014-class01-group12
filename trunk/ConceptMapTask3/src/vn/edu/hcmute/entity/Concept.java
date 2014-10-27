package vn.edu.hcmute.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "concept")
public class Concept implements java.io.Serializable{
	
	@Id
	@Column(name = "ConceptID")
	private String conceptID;
	
	@Column(name = "ConceptName", nullable = false)
	private String conceptName;
	
	@Column(name = "Document")
	private String document;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "concept1")
	private Set<Relation> relation1;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "concept2")
	private Set<Relation> relation2;
	
	@OneToOne(mappedBy="concept")
	private Node node;
	
	@ManyToOne
	@JoinColumn(name="ConceptMapID")
	private ConceptMap conceptMap;
	
	public ConceptMap getConceptMap() {
		return conceptMap;
	}
	public void setConceptMap(ConceptMap conceptMap) {
		this.conceptMap = conceptMap;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
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
	public String getConceptID() {
		return conceptID;
	}
	public void setConceptID(String conceptID) {
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
