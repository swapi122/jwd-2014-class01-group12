package vn.edu.hcmute.entity;

import javax.persistence.*;

@Entity
@Table(name = "studentanswer")
public class StudentAnswer {
	
	@Id
	@GeneratedValue
	@Column(name = "StudentAnswerID")
	private long studentAnswerID;
	
	@Column(name = "Score")
	private double score;
	
	@ManyToOne
	@JoinColumn(name = "TaskID")
	private Task task;
	
	@OneToOne
	@JoinColumn(name = "ConceptMapID", unique = true, nullable = false)
	private ConceptMap conceptMap;
	
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public ConceptMap getConceptMap() {
		return conceptMap;
	}
	public void setConceptMap(ConceptMap conceptMap) {
		this.conceptMap = conceptMap;
	}
	public long getStudentAnswerID() {
		return studentAnswerID;
	}
	public void setStudentAnswerID(long studentAnswerID) {
		this.studentAnswerID = studentAnswerID;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
}
