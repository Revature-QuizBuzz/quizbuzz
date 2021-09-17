import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionAnswerComponent } from './answer/question-answer.component';
import { QuestionComponent } from './question/question.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { NewTagsComponent } from './new-tags/new-tags.component';
import { CreateQuizesComponent } from './create-quizes/create-quizes.component';
import { ScoreBoardComponent } from './scoreboard/scoreboard.component';
import { TotalUserPointsComponent } from './total-user-points/total-user-points.component';


export const routes: Routes = [
  {path: '', component:HomeComponent, canActivate:[AuthGuard]},
  {path: 'home', component: HomeComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path:"tags/new", component: NewTagsComponent},
  {path: 'quiz/new', component:CreateQuizesComponent},
  {path: 'scoreboard', component:ScoreBoardComponent},
  {path: 'totalpoints', component:TotalUserPointsComponent},
  {path: 'tags/new', component: NewTagsComponent},
  {path: 'quiz/new', component:CreateQuizesComponent},
  {path: 'newquestionanswer', component: QuestionAnswerComponent, outlet: "answer"},
  {path: 'newquestion', component: QuestionComponent, outlet: "question"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
