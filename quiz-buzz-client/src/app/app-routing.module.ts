import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { NewTagsComponent } from './new-tags/new-tags.component';
import { QuizSubmissionComponent } from './take-quiz-components/quiz-submission/quiz-submission.component';
import { CreateQuizesComponent } from './create-quizes/create-quizes.component';
import { QuizSelectionComponent } from './take-quiz-components/quiz-selection/quiz-selection.component';
import { TaketestComponent } from './take-quiz-components/taketest/taketest.component';


export const routes: Routes = [
  {path: '', component:HomeComponent, canActivate:[AuthGuard]},
  {path: 'home', component: HomeComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'testresults', component: QuizSubmissionComponent},
  {path:"tags/new", component: NewTagsComponent},
  {path: 'quiz/new', component:CreateQuizesComponent},
  {path: '/quiz/selection', component: QuizSelectionComponent},
  {path: '/take/quiz', component: TaketestComponent},
  {path: '/quiz/submit', component: QuizSubmissionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
