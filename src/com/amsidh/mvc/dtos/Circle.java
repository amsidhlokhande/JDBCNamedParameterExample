/**
 * 
 */
package com.amsidh.mvc.dtos;

import java.io.Serializable;

/**
 * @author amsidhlokhande
 * 
 */
public class Circle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer circleId;
	private String circleName;

	
	public Circle() {
		super();
	
	}
	

	public Circle(Integer circleId, String circleName) {
		super();
		this.circleId = circleId;
		this.circleName = circleName;
	}


	public Integer getCircleId() {
		return circleId;
	}

	public void setCircleId(Integer circleId) {
		this.circleId = circleId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

}
