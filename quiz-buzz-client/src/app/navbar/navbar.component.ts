import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  logo = 'assets/rev-logo_281_29.png';
  avatar = "assets/interns.png";
  navClass = "navbar navbar-expand-lg navbar-dark bg-dark";
  logoClass="d-inline-block align-text-top"
  dropdownLinkClass="d-block link-dark text-decoration-none dropdown-toggle text-light"

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  //add in routing here

  signOut() {
    localStorage.clear();
    this.router.navigate(['login']);
  }

  getName() {
    if(localStorage.getItem("id") === null)
      return ""; 
    return String(localStorage.getItem("firstName")) + " " + String(localStorage.getItem("lastName"));
  }

  quizSelection(){
    this.router.navigate(['quiz/selection'])
  }
}
