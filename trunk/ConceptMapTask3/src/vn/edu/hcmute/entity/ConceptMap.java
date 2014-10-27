package vn.edu.hcmute.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "conceptmap")
public class ConceptMap implements java.io.Serializable{
	
	@Id
	@Column(name = "ConceptMapID")
	private String conceptMapID;
	
	@Column(name="ConceptMapName")
	private String conceptMapName;
	
	@Column(name = "CreateDate")
	private Date createDate;
	
	@Column(name = "SubmitDate")
	private Date submitDate;
	
	@Column(name = "Submited")
	private Boolean submited;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="conceptMap")
	private Set<Relation> relations;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="conceptMap")
	private Set<Concept> concepts;
	
	public Set<Concept> getConcepts() {
		return concepts;
	}
	public void setConcepts(Set<Concept> concepts) {
		this.concepts = concepts;
	}
	public String getConceptMapID() {
		return conceptMapID;
	}
	public void setConceptMapID(String conceptMapID) {
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
	public Boolean isSubmited() {
		return submited;
	}
	public void setSubmited(Boolean submited) {
		this.submited = submited;
	}
	public String getConceptMapName() {
		return conceptMapName;
	}
	public void setConceptMapName(String conceptMapName) {
		this.conceptMapName = conceptMapName;
	}
	public Set<Relation> getRelations() {
		return relations;
	}
	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
	}
}
