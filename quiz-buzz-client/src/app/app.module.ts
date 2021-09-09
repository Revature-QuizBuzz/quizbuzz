import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TaketestComponent } from './taketest/taketest.component';
import { QuizSelectionComponent } from './quiz-selection/quiz-selection.component';
import { QuizSubmissionComponent } from './quiz-submission/quiz-submission.component';


const routes:Routes = []

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TaketestComponent,
    QuizSelectionComponent,
    QuizSubmissionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
