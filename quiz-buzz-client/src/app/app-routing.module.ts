import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionAnswerComponent } from './question-answer/question-answer.component';
import { QuestionComponent } from './question/question.component';

const routes: Routes = [
  {path: 'newquestionanswer', component: QuestionAnswerComponent},
  {path: 'newquestion', component: QuestionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
