package vn.edu.hcmute.entity;

import javax.persistence.*;

@Entity
@Table(name="node")
public class Node {

	@Id
	@GeneratedValue
	@Column(name="NodeID")
	private long nodeID;
	
	@Column(name="x")
	private int x;
	
	@Column(name="y")
	private int y;
	
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Concept content;

	public long getNodeID() {
		return nodeID;
	}

	public void setNodeID(long nodeID) {
		this.nodeID = nodeID;
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

	public Concept getContent() {
		return content;
	}

	public void setContent(Concept content) {
		this.content = content;
	}
	
}
