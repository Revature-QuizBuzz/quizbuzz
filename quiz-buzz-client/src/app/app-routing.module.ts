import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionAnswerComponent } from './answer/question-answer.component';
import { QuestionComponent } from './question/question.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { NewTagsComponent } from './new-tags/new-tags.component';
import { CreateQuizesComponent } from './create-quizes/create-quizes.component';
import {ListCreatedQuizzesComponent} from './list-created-quizzes';


export const routes: Routes = [
  {path: '', component:HomeComponent, canActivate:[AuthGuard]},
  {path: 'home', component: HomeComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'tags/new', component: NewTagsComponent},
  {path: 'quiz/new', component:CreateQuizesComponent},
  {path: 'newquestionanswer', component: QuestionAnswerComponent, outlet: "answer"},
  {path: 'newquestion', component: QuestionComponent, outlet: "question"},
  {path: 'list-created-quizzes', component: ListCreatedQuizzesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
