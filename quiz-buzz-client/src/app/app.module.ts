import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { NewTagsComponent } from './new-tags/new-tags.component';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { routes } from './app-routing.module';
import { QuizSubmissionComponent } from './take.quiz.components/quiz-submission/quiz-submission.component';
import { QuizSelectionComponent } from './take.quiz.components/quiz-selection/quiz-selection.component';
import { TaketestComponent } from './take.quiz.components/taketest/taketest.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TaketestComponent,
    QuizSubmissionComponent,
    QuizSelectionComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    NewTagsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
