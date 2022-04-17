import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Post } from './post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseURL = "http://localhost:9999/post";

  constructor(private httpClient: HttpClient) { }
  
  getPostList(): Observable<Post[]>{
    return this.httpClient.get<Post[]>(`${this.baseURL}/getAll`);
  }

  createPost(post: Post): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/create`, post);
  }

  getPostById(post_id: number): Observable<Post>{
    return this.httpClient.get<Post>(`${this.baseURL}/getdetails/${post_id}`);
  }

  updatePost(post_id: number, post: Post): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/update`, post);
  }

  deletePost(post_id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete/${post_id}`);
  }
}
