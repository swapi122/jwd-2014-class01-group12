package vn.edu.hcmute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relation")
public class Relation implements java.io.Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ConceptID1")
	private Concept concept1;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ConceptID2")
	private Concept concept2;
	
	@Column(name="title")
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne
	@JoinColumn(name="ConceptMapID")
	private ConceptMap conceptMap;

	public ConceptMap getConceptMap() {
		return conceptMap;
	}

	public void setConceptMap(ConceptMap conceptMap) {
		this.conceptMap = conceptMap;
	}

	public Concept getConcept1() {
		return concept1;
	}

	public void setConcept1(Concept concept1) {
		this.concept1 = concept1;
	}

	public Concept getConcept2() {
		return concept2;
	}

	public void setConcept2(Concept concept2) {
		this.concept2 = concept2;
	}
}
