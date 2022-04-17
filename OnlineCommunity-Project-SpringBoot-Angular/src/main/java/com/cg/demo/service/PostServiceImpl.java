package com.cg.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.demo.dao.PostDaoI;
import com.cg.demo.entities.Post;

@Service

public class PostServiceImpl implements PostServiceI{
	@Autowired
	private PostDaoI dao;
	
	public Post CreatePost(Post p) {
		return dao.CreatePost(p);
	}
	
	public Post findPostById(long postId) {
		return dao.findPostById(postId);
	}
	public Post updatePost(Post p) {
		return dao.updatePost(p);
	}
	public List<Post> findAllPosts(){
		 return dao.findAllPosts();
	}
	public void deletePost(long postId) {
		 dao.deletePost(postId);
	}

}
