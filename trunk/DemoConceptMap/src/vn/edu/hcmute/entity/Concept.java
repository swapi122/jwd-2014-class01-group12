package vn.edu.hcmute.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "concept")
public class Concept {
	
	@Id
	@GeneratedValue
	@Column(name = "ConceptID")
	private long ID;
	
	@Column(name = "ConceptName")
	private String name;
	
	@Column(name = "Document")
	private String document;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "concept1")
	private List<Relation> relation1;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "concept2")
	private List<Relation> relation2;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="content")
	private Node appearance;
	
	public List<Relation> getRelation1() {
		return relation1;
	}
	public void setRelation1(List<Relation> relation1) {
		this.relation1 = relation1;
	}
	public List<Relation> getRelation2() {
		return relation2;
	}
	public void setRelation2(List<Relation> relation2) {
		this.relation2 = relation2;
	}
	public long getConceptID() {
		return ID;
	}
	public void setConceptID(long conceptID) {
		this.ID = conceptID;
	}
	public String getConceptName() {
		return name;
	}
	public void setConceptName(String conceptName) {
		this.name = conceptName;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
}
