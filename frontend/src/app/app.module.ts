import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap/modal';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { ParentComponent } from './components/parent/parent.component';
import { ChildComponent } from './components/child/child.component';
import { ProfileComponent } from './components/profile/profile.component';
import { QuestionContainerComponent } from './components/question-container/question-container.component';
import { QuestionBoxComponent } from './components/question-box/question-box.component';
import { QuestionItemComponent } from './components/question-item/question-item.component';
import { QuestionItemV2Component } from './components/question-item-v2/question-item-v2.component';
import { BorderComponent } from './components/border/border.component';
import { PipeDemoComponent } from './components/pipe-demo/pipe-demo.component';
import { HighlightDirective } from './highlight.directive';
import { ReactiveFormDemoComponent } from './components/reactive-form-demo/reactive-form-demo.component';
import { MovieCounterComponent } from './components/movie-counter/movie-counter.component';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import { TemplateFormDemoComponent } from './components/template-form-demo/template-form-demo.component';
import { ChangeDetectionDemoComponent } from './components/change-detection-demo/change-detection-demo.component';
import { HomePageComponent } from './page/home-page/home-page.component';
import { MovieListPageComponent } from './page/movie-list-page/movie-list-page.component';
import { MovieDetailPageComponent } from './page/movie-detail-page/movie-detail-page.component';
import { NotFoundComponent } from './page/not-found/not-found.component';
import { MovieDetailsComponent } from './components/movie-details/movie-details.component';
import { LoginPageComponent } from './page/login-page/login-page.component';
import {TokenInterceptor} from "./auth/interceptor/TokenInterceptor";
import { LogoutComponent } from './page/logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    ParentComponent,
    ChildComponent,
    ProfileComponent,
    QuestionContainerComponent,
    QuestionBoxComponent,
    QuestionItemComponent,
    QuestionItemV2Component,
    BorderComponent,
    PipeDemoComponent,
    HighlightDirective,
    ReactiveFormDemoComponent,
    MovieCounterComponent,
    MovieListComponent,
    TemplateFormDemoComponent,
    ChangeDetectionDemoComponent,
    HomePageComponent,
    MovieListPageComponent,
    MovieDetailPageComponent,
    NotFoundComponent,
    MovieDetailsComponent,
    LoginPageComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    ModalModule.forRoot()
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
