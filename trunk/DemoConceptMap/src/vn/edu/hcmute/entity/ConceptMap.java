package vn.edu.hcmute.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "conceptmap")
public class ConceptMap {
	
	@Id
	@GeneratedValue
	@Column(name = "ConceptMapID")
	private long conceptMapID;
	
	@Column(name="ConceptMapName")
	private String Name;
	
	public String getConceptMapName() {
		return Name;
	}
	public void setConceptMapName(String conceptMapName) {
		this.Name = conceptMapName;
	}
	public void setConceptMapID(long conceptMapID) {
		this.conceptMapID = conceptMapID;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conceptMap")
	private List<Relation> Relations;
	
	public List<Relation> getRelationList() {
		return Relations;
	}
	public void setRelationList(List<Relation> relationList) {
		this.Relations = relationList;
	}

	public long getConceptMapID() {
		return conceptMapID;
	}
	public void setConceptMapID(int conceptMapID) {
		this.conceptMapID = conceptMapID;
	}
}
