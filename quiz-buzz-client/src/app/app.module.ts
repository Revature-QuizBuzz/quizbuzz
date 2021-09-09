import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TaketestComponent } from './take.quiz.components/taketest/taketest.component';
import { QuizSubmissionComponent } from './take.quiz.components/quiz-submission/quiz-submission.component';
import { QuizSelectionComponent} from './take.quiz.components/quiz-selection/quiz-selection.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TaketestComponent,
    QuizSubmissionComponent,
    QuizSelectionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
