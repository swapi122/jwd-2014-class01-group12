package vn.edu.hcmute.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Node")
public class Node implements java.io.Serializable{
	
	@Id
    @Column(name="ConceptID", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="concept"))
	private String conceptID;
	
	@Column(name="Width")
	private int width;
	
	@Column(name="Height")
	private int height;
	
	@Column(name="x")
	private int x;
	
	@Column(name="y")
	private int y;
	
	@Column(name="angle")
	private int angle;
	
	@Column(name="Background")
	private String background;
	
	@Column(name="FontColor")
	private String fontColor;
	
	@OneToOne
	@PrimaryKeyJoinColumn()
	private Concept concept;

	public String getConceptID() {
		return conceptID;
	}

	public void setConceptID(String conceptID) {
		this.conceptID = conceptID;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	
	
}
