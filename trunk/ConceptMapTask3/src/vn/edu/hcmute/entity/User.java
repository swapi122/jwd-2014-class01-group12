package vn.edu.hcmute.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable{
	@Id
	@GeneratedValue
	@Column (name = "UserID")
	private long userID;
	
	@Column (name = "Email", nullable = false)
	private String email;
	
	@Column (name = "PassWd", nullable = false)
	private String passWd;
	
	@ManyToOne
	@JoinColumn (name = "PermissionID", nullable = false)
	private Permission permission;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
}
