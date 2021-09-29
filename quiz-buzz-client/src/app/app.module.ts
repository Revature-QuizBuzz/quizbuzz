import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { EditQuizComponent } from './edit-quiz/edit-quiz.component';
import { MyQuizzesComponent } from './my-quizzes/my-quizzes.component';
import { QuestionAnswerComponent } from './answer/question-answer.component';
import { HttpClientModule } from '@angular/common/http';
import { QuestionComponent } from './question/question.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { NewTagsComponent } from './new-tags/new-tags.component';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { routes } from './app-routing.module';
import { CreateQuizesComponent } from './create-quizes/create-quizes.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AttachTagsComponent } from './attach-tags/attach-tags.component';
import { TotalUserPointsComponent } from './total-user-points/total-user-points.component';
import { ScoreBoardComponent } from './scoreboard/scoreboard.component';
import { TagsShowPageComponent } from './tags-show-page/tags-show-page.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,

    EditQuizComponent,
    MyQuizzesComponent,

    QuestionAnswerComponent,
    QuestionComponent,
    TotalUserPointsComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    NewTagsComponent,
    CreateQuizesComponent,
    ScoreBoardComponent,
    TagsShowPageComponent,
    AttachTagsComponent,
    ScoreBoardComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    NgMultiSelectDropDownModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
