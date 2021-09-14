import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
<<<<<<< Updated upstream
import { TaketestComponent } from './takequizcomponents/taketest/taketest.component';
import { QuizSubmissionComponent } from './takequizcomponents/quiz-submission/quiz-submission.component';
import { QuizSelectionComponent } from './takequizcomponents/quiz-selection/quiz-selection.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';

 

=======
import { TaketestComponent } from './take-quiz-components/taketest/taketest.component';
import { QuizSubmissionComponent } from './take-quiz-components/quiz-submission/quiz-submission.component';
import { QuizSelectionComponent } from './take-quiz-components/quiz-selection/quiz-selection.component';
import { NavbarComponent } from './navbar/navbar.component';
>>>>>>> Stashed changes

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
<<<<<<< Updated upstream
   TaketestComponent,
   QuizSubmissionComponent,
   QuizSelectionComponent,
 
  
=======
    TaketestComponent,
    QuizSubmissionComponent,
    QuizSelectionComponent,
    NavbarComponent
>>>>>>> Stashed changes
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
