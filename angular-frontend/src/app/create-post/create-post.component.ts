import { Component, OnInit } from '@angular/core';
import { Post } from '../post';
import { PostService } from '../post.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-Post.component.html',
  styleUrls: ['./create-Post.component.css']
})
export class CreatePostComponent implements OnInit {

  post: Post = new Post();
  constructor(private postService: PostService,
    private router: Router) { }

  ngOnInit(): void {
  }

  savePost(){
    this.postService.createPost(this.post).subscribe( data =>{
      console.log(data);
      this.goToPostList();
    },
    error => console.log(error));
  }

  goToPostList(){
    this.router.navigate(['/posts']);
  }
  
  onSubmit(){
    console.log(this.post);
    this.savePost();
  }
}
