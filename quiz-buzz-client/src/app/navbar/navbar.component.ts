import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  logo = 'assets/rev-logo_281_29.png';
  avatar = "assets/interns.png";
  constructor() { }

  ngOnInit(): void {
  }

}
