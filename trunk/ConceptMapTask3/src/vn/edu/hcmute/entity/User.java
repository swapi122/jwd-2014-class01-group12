package vn.edu.hcmute.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	@Column (name = "UserID")
	private long userID;
	
	@Column (name = "UserName", nullable = false)
	private String userName;
	
	@Column (name = "PassWd", nullable = false)
	private String passWd;
	
	@ManyToOne
	@JoinColumn (name = "PermissionID", nullable = false)
	private Permission permission;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Assignment> assignment;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Task> task;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Shared> shared;
	
	public Set<Assignment> getAssignment() {
		return assignment;
	}
	public void setAssignment(Set<Assignment> assignment) {
		this.assignment = assignment;
	}
	public Set<Task> getTask() {
		return task;
	}
	public void setTask(Set<Task> task) {
		this.task = task;
	}
	public Set<Shared> getShared() {
		return shared;
	}
	public void setShared(Set<Shared> shared) {
		this.shared = shared;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
}
