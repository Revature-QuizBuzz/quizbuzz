import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import {Routes, RouterModule} from '@angular/router';
import { FormsModule } from '@angular/forms';
//import { routes } from './app-routing.module';//don't know why this import does not work


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateQuestionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    //RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
