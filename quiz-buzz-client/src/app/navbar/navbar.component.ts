import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppRoutingModule } from '../app-routing.module';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  logo = 'assets/rev-logo_281_29.png';
  avatar = "assets/interns.png";
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  signOut() {
    localStorage.clear();
    this.router.navigate(['login']);
  }
}
