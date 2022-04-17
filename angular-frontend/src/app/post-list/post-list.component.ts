import { Component, OnInit } from '@angular/core';
import { Post } from '../post'
import { PostService } from '../post.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  postId: number;
  posts: Post[];

  constructor(private postService: PostService,
    private router: Router) { }

  ngOnInit(): void {
    this.getPost();
  }

  private getPost(){
    this.postService.getPostList().subscribe(data => {
      this.posts = data;
    });
  }

  postDetails(postId: number){
    this.router.navigate(['post-details', postId]);
  }

  updatePost(postId: number){
    this.router.navigate(['update-post', postId]);
  }

  deletePost(post_id: number){
    this.postService.deletePost(post_id).subscribe( data => {
      console.log(data);
      this.getPost();
    })
  }
}
