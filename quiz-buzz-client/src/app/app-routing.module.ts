import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditQuizComponent } from './edit-quiz/edit-quiz.component';
import { MyQuizzesComponent } from './my-quizzes/my-quizzes.component';

const routes: Routes = [
  // :id is route parameter
  {path: 'my-quizzes/', component:MyQuizzesComponent},
  {path: 'my-quizzes/edit/:id', component:EditQuizComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
