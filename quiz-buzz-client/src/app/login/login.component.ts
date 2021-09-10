import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/users'
import { LoginService } from '../services/login.service';
import { AppRoutingModule } from '../app-routing.module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  incorrect:boolean = false;

  constructor(private loginService:LoginService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(form:NgForm): void {
    // let user = new User(0, form.value.username, form.value.password, "", "", 0);
    let user:User = {id: 0, username: form.value.username, password: form.value.password, firstName: "", lastName: "", total_points: 0, total_possible_points: 0, point_percentage: 0, userScores: [], quizzes: []};

    this.loginService.login(user).subscribe({
      next: (data:User) => {
        if(data === null) {
          this.incorrect = true;
        } else {
          console.log(JSON.stringify(data));
          localStorage.setItem("id", String(data.id));
          localStorage.setItem("username", String(data.username));
          localStorage.setItem("firstName", String(data.firstName));
          localStorage.setItem("lastName", String(data.lastName));
          this.router.navigate(['']);
        }
      }
    })
  }

}
