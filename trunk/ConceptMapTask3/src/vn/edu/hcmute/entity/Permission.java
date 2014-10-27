package vn.edu.hcmute.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="permission")
public class Permission implements java.io.Serializable{
	
	@Id
	@GeneratedValue
	@Column (name = "PermissionID")
	private int permissionID;
	
	@Column (name = "PermissionName")
	private String permissionName;
	
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "permission")
	private Set<User> user;
	
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public int getPermissionID() {
		return permissionID;
	}
	public void setPermissionID(int permissionID) {
		this.permissionID = permissionID;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	} 

}
