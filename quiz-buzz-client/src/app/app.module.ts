import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { TotalUserPointsComponent } from './total-user-points/total-user-points.component';
import { FormsModule } from '@angular/forms';


const routes: Routes = [
  {path: 'totaluserpoints', component: TotalUserPointsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TotalUserPointsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
