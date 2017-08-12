package com.movie;

public class Director {
	
	private String name;
	
	private String gender;
	
	public Director(){
		
	}
	
	public Director(String name, String gender){
		
		this.name = name;
		this.gender = gender;
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

}
