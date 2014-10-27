package vn.edu.hcmute.entity;

import javax.persistence.*;

@Entity
@Table(name="vertice")
public class Vertice implements java.io.Serializable{
	@Id
	@GeneratedValue
	@Column(name="VerticeID")
	private long verticeID;
	
	@Column(name="x")
	private int x;
	
	@Column(name="y")
	private int y;
	
	@ManyToOne
	@JoinColumn(name="RelationID")
	private Relation relation;

	public long getVerticeID() {
		return verticeID;
	}

	public void setVerticeID(long verticeID) {
		this.verticeID = verticeID;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}
}
