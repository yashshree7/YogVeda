package com.yogveda.model;

public class YogaPose {
	 	private Long id;
	    private String name;
	    private String description;
	    private String benefits;
	    private String difficulty;
	    private int duration;
	    private String imageUrl;
	    
	    //Getters and Setters method
	    public Long getId() {
	    	return id;
	    }
	    public void setId(Long id) {
	    	this.id=id;
	    }
	    
	    public String getName() {
	    	return name;
	    }
	    public void setName(String name) {
	    	this.name=name;
	    }
	    
	    public String getDescription() {
	    	return description;
	    }
	    public void setDescription(String description) {
	    	this.description=description;
	    }
	    
	    public String getBenefits() {
	    	return benefits;
	    }
	    public void setBenefits(String benefits) {
	    	this.benefits=benefits;
	    }
	    
	    public String getDifficulty() {
	    	return difficulty;
	    }
	    public void setDifficulty(String difficulty) {
	    	this.difficulty=difficulty;
	    }
	    
	    public int getDuration() {
	    	return duration;
	    }
	    public void setDuration(int duration) {
	    	this.duration=duration;
	    }
	    
	    public String getImageUrl() {
	    	return imageUrl;
	    }
	    public void setImageUrl(String imageUrl) {
	    	this.imageUrl=imageUrl;
	    }
}
