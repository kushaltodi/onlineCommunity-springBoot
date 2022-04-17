package com.cg.demo.dao;
import java.util.List;

import com.cg.demo.entities.Post;

public interface PostDaoI {
	
	Post CreatePost(Post p);
	Post findPostById(long postId);
	Post updatePost(Post p); 
	List<Post> findAllPosts();
	void deletePost(long postId);
}

