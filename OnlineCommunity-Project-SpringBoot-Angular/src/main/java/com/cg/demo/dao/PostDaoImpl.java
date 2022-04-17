package com.cg.demo.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.cg.demo.entities.Post;

@Repository
@Transactional
public class PostDaoImpl implements PostDaoI {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Post CreatePost(Post p) {
		return entityManager.merge(p);
	}

	@Override
	public Post findPostById(long empId) {
		return entityManager.find(Post.class,empId);
	}

	@Override
	public Post updatePost(Post postt) {
//		Post p=entityManager.find(Post.class,postt.getPostId());
		Post p=findPostById(postt.getPostId());
		p.setPostName(postt.getPostName());
		p.setDescription(postt.getDescription());
		p=entityManager.merge(p);
		return p;
	}
	
	@Override
	public List<Post> findAllPosts() {
		Query q = entityManager.createQuery("select e from Post e");
	    List<Post> list=q.getResultList();
		return list;
	}
	@Override
	public void deletePost(long postId) {
		Post p=entityManager.find(Post.class, postId);
		entityManager.remove(p);
	}

}
	
