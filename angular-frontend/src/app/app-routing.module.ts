import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PostListComponent } from './post-list/post-list.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { UpdatePostComponent } from './update-post/update-post.component';

const routes: Routes = [
  {path: 'posts', component: PostListComponent},
  {path: 'create-post', component: CreatePostComponent},
  {path: '', redirectTo: 'posts', pathMatch: 'full'},
  {path: 'update-post/:post_id', component: UpdatePostComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }
