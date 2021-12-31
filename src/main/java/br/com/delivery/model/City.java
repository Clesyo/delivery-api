package br.com.delivery.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class City {

	private Long id;

	private String name;

	private Integer ibgeCode;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

	public City(String name, Integer ibgeCode, State state) {
		this.name = name;
		this.ibgeCode = ibgeCode;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIbgeCode() {
		return ibgeCode;
	}

	public void setIbgeCode(Integer ibgeCode) {
		this.ibgeCode = ibgeCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
	
}
