package com.finance.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sureshtab")
public class SureshTab implements Serializable {
	
	private static final long serialVersionUID = -5903825706542600208L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="myp", unique = true, nullable = false)
	private Long id;
	
	@Column(name="col1")
	private String col1;
	
	@Column(name="col2")
	private String col2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}
}
