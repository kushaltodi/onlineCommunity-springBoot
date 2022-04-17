import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';
import { Post } from '../post';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-post',
  templateUrl: './update-post.component.html',
  styleUrls: ['./update-post.component.css']
})
export class UpdatePostComponent implements OnInit {

  postId: number;
  post: Post = new Post();
  constructor(private postService: PostService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.postId = this.route.snapshot.params['postId'];

    this.postService.getPostById(this.postId).subscribe(data => {
      this.post = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.postService.updatePost(this.postId, this.post).subscribe( data =>{
      this.goToEmployeeList();
    }
    , error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/posts']);
  }
}
