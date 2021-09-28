import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EditQuizComponent } from './edit-quiz/edit-quiz.component';
import { MyQuizzesComponent } from './my-quizzes/my-quizzes.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EditQuizComponent,
    MyQuizzesComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
