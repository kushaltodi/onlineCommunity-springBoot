package com.cg.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Post")
public class Post {
	@Id
	@GeneratedValue
	private long postId;
	
	private String postName;
	
	private String description;

	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//constructor
	public Post() {
		super();
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postName=" + postName + ", description=" + description + "]";
	}


}
