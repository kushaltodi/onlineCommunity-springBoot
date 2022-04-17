package com.cg.demo.service;
import java.util.List;

import com.cg.demo.entities.Post;

public interface PostServiceI {

    Post CreatePost(Post p);
    
    Post findPostById(long postId);
	
    Post updatePost(Post p); 
	
	List<Post> findAllPosts();
	
	void deletePost(long postId);
	
}
