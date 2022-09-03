import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomePageComponent} from "./page/home-page/home-page.component";
import {MovieListPageComponent} from "./page/movie-list-page/movie-list-page.component";
import {MovieDetailPageComponent} from "./page/movie-detail-page/movie-detail-page.component";
import {NotFoundComponent} from "./page/not-found/not-found.component";

const routes: Routes = [
  { path: 'home',title: 'Hello', component: HomePageComponent },
  { path: 'movies', component: MovieListPageComponent },
  { path: 'movies/:id',
    component: MovieDetailPageComponent,
   /* canActivate: [ AuthGuard ]*/
  },
  { path: 'hello',redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
