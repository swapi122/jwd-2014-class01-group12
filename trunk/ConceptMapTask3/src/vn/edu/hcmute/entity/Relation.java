package vn.edu.hcmute.entity;

import javax.persistence.*;

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
