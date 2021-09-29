import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
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
import { TaketestComponent } from './take-quiz-components/taketest/taketest.component';
import { QuizSubmissionComponent } from './take-quiz-components/quiz-submission/quiz-submission.component';
import { QuizSelectionComponent } from './take-quiz-components/quiz-selection/quiz-selection.component';
import { AttachTagsComponent } from './attach-tags/attach-tags.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { TotalUserPointsComponent } from './total-user-points/total-user-points.component';
import { ScoreBoardComponent } from './scoreboard/scoreboard.component';
import { TagsShowPageComponent } from './tags-show-page/tags-show-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    QuestionAnswerComponent,
    QuestionComponent,
    TotalUserPointsComponent,
    QuizSubmissionComponent,
    NavbarComponent,
    TaketestComponent,
    QuizSelectionComponent,
    HomeComponent,
    FooterComponent,
    NewTagsComponent,
    CreateQuizesComponent,
    ScoreBoardComponent,
    TagsShowPageComponent,
    AttachTagsComponent,
    TaketestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    NgMultiSelectDropDownModule.forRoot(),
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
