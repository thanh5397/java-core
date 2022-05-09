package com.phamvanthanh.dto;

public class FactDTO extends AbstractDTO<FactDTO>  {
	private String comment;
	private String image;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
