import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
import { EditQuizComponent } from './edit-quiz/edit-quiz.component';
import { MyQuizzesComponent } from './my-quizzes/my-quizzes.component';

const routes: Routes = [
  // :id is route parameter
  {path: 'my-quizzes/', component:MyQuizzesComponent},
  {path: 'my-quizzes/edit/:id', component:EditQuizComponent}

=======
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
>>>>>>> 61bcad626f4f30ac554db28be1bd22fc809621dd
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
