package vn.edu.hcmute.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "relation")
public class Relation implements java.io.Serializable{
	
	@Id
	@Column(name="RelationID")
	private String relationID;
	
	@Column(name="Title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "ConceptID1")
	private Concept concept1;
	
	@ManyToOne
	@JoinColumn(name = "ConceptID2")
	private Concept concept2;
	
	@ManyToOne
	@JoinColumn(name="ConceptMapID")
	private ConceptMap conceptMap;

	@OneToMany(fetch=FetchType.EAGER,mappedBy="relation")
	private List<Vertice> vertices;
	
	public List<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}

	public String getRelationID() {
		return relationID;
	}

	public void setRelationID(String relationID) {
		this.relationID = relationID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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
