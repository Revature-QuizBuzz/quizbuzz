import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionAnswerComponent } from './answer/question-answer.component';
import { QuestionComponent } from './question/question.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { NewTagsComponent } from './new-tags/new-tags.component';
import { TagsShowPageComponent } from './tags-show-page/tags-show-page.component';
import { ScoreBoardComponent } from './scoreboard/scoreboard.component';
import { TotalUserPointsComponent } from './total-user-points/total-user-points.component';
import { QuizSubmissionComponent } from './take-quiz-components/quiz-submission/quiz-submission.component';
import { CreateQuizesComponent } from './create-quizes/create-quizes.component';
import { QuizSelectionComponent } from './take-quiz-components/quiz-selection/quiz-selection.component';
import { TaketestComponent } from './take-quiz-components/taketest/taketest.component';
import { AttachTagsComponent } from './attach-tags/attach-tags.component';
import { TagGuardGuard } from './tag-guard.guard';
import { DeleteQuizzesComponent } from './delete-quizzes/delete-quizzes.component';


export const routes: Routes = [
  {path: '', component:HomeComponent, canActivate:[AuthGuard]},
  {path: 'home', component: HomeComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'quiz/submit', component: QuizSubmissionComponent},
  {path:"tags/new", component: NewTagsComponent},
  {path: 'quiz/new', component:CreateQuizesComponent},
  {path: 'tags/new', component: NewTagsComponent},
  {path: 'quiz/new', component:CreateQuizesComponent},
  {path: 'newquestionanswer', component: QuestionAnswerComponent, outlet: "answer"},
  {path: 'newquestion', component: QuestionComponent, outlet: "question"},
  {path: 'scoreboard', component:ScoreBoardComponent, canActivate:[AuthGuard]},
  {path: 'totalpoints', component:TotalUserPointsComponent, canActivate:[AuthGuard]},
  {path: 'quiz/new', component:CreateQuizesComponent, canActivate:[AuthGuard], children:[
    {path: 'tags/edit', component:AttachTagsComponent, canActivate:[AuthGuard], children:[
      {path: 'tags/new', component: NewTagsComponent, canActivate:[AuthGuard]}
    ]},
    {path: 'newquestionanswer', component: QuestionAnswerComponent, outlet: 'answer', canActivate:[AuthGuard]},
    {path: 'newquestion', component: QuestionComponent, outlet: "question", canActivate:[AuthGuard]},
  ]},
  {path: 'tags', component: TagsShowPageComponent, canActivate:[AuthGuard, TagGuardGuard]},
  {path: 'testresults', component: QuizSubmissionComponent, canActivate:[AuthGuard]},
  {path: 'quiz/selection', component: QuizSelectionComponent, canActivate:[AuthGuard]},
  {path: 'take/quiz', component: TaketestComponent, canActivate:[AuthGuard]},
  {path: 'quiz/submit', component: QuizSubmissionComponent, canActivate:[AuthGuard]},
  {path: 'quiz/management', component: DeleteQuizzesComponent, canActivate:[AuthGuard, TagGuardGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
