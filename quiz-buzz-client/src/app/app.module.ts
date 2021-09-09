import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CreateQuizesComponent } from './create-quizes/create-quizes.component';
import { RouterModule, Routes } from '@angular/router';

const routes:Routes = [
  {path: '', component:CreateQuizesComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateQuizesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
