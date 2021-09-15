import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/users'
import { LoginService } from '../services/login.service';

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
    let user:User = {username: form.value.username, password: form.value.password};

    this.loginService.login(user).subscribe({
      next: (data:User) => {
        if(data === null) {
          this.incorrect = true;
        } else {
          console.log(JSON.stringify(data));
          localStorage.setItem("id", String(data.userId));
          localStorage.setItem("username", String(data.username));
          localStorage.setItem("firstName", String(data.firstName));
          localStorage.setItem("lastName", String(data.lastName));
          this.router.navigate(['home']);
        }
      }
    })
  }

}
