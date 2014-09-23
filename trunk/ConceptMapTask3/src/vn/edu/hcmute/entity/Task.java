package vn.edu.hcmute.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue
	@Column(name = "TaskID")
	private long taskID;
	
	@ManyToOne
	@JoinColumn(name = "UserID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "AssignmentID")
	private Assignment assignment;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
	private Set<StudentAnswer> studentAnswers;
	
	public Set<StudentAnswer> getStudentAnswers() {
		return studentAnswers;
	}
	public void setStudentAnswers(Set<StudentAnswer> studentAnswers) {
		this.studentAnswers = studentAnswers;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public long getTaskID() {
		return taskID;
	}
	public void setTaskID(long taskID) {
		this.taskID = taskID;
	}
}
