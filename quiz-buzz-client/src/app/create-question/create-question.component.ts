import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {

  constructor(Http: HttpClient, 
    private router: Router) { }

    

  ngOnInit(): void {
  }

}
