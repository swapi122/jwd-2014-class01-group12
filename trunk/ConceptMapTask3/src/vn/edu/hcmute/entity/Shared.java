package vn.edu.hcmute.entity;

import javax.persistence.*;

@Entity
@Table(name = "shared")
public class Shared implements java.io.Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ConceptMapID")
	private ConceptMap conceptMap;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ReceivedUserID")
	private User user;

	public ConceptMap getConceptmap() {
		return conceptMap;
	}

	public void setConceptmap(ConceptMap conceptMap) {
		this.conceptMap = conceptMap;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
