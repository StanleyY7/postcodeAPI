package postcode.project.backend.postcodes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "postcodes")
public class PostCode {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	
	@Column
	String suburb;
	
	@Column
	Long areaCode;
	
	@Column
	String state;
	
	// Getters and Setters

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public Long getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	// Constructors
	
	public PostCode(Long id, String suburb, Long areaCode, String state) {
		super();
		Id = id;
		this.suburb = suburb;
		this.areaCode = areaCode;
		this.state = state;
	}

	public PostCode() {};

}
