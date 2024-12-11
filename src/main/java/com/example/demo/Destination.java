package com.example.demo;

import java.util.Arrays;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.*;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
    
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	@Override
	public String toString() {
		return "Destination [id=" + id + ", title=" + title + ", description=" + description + ", imageName="
				+ imageName + ", imageType=" + imageType + ", imageData=" + Arrays.toString(imageData) + "]";
	}
    
    
}
