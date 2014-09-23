package vn.edu.hcmute.entity;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback implements java.io.Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ConceptMapID")
	private ConceptMap conceptMap;

	@Id
	@ManyToOne
	@JoinColumn(name = "ConceptID")
	private Concept concept;

	public ConceptMap getConceptMap() {
		return conceptMap;
	}

	public void setConceptMap(ConceptMap conceptMap) {
		this.conceptMap = conceptMap;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}
}
