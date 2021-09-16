import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TaketestComponent } from './takequizcomponents/taketest/taketest.component';
import { QuizSubmissionComponent } from './takequizcomponents/quiz-submission/quiz-submission.component';
import { QuizSelectionComponent } from './takequizcomponents/quiz-selection/quiz-selection.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule , ReactiveFormsModule } from '@angular/forms';
 


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
   TaketestComponent,
   QuizSubmissionComponent,
   QuizSelectionComponent,
 
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
