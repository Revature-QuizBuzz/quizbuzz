import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Question } from '../models/questions';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {
  //Http: any;//shouldn't need this but whatever

  constructor(private Http: HttpClient, 
    private router: Router) { }

  onSubmit(form: NgForm){
    console.log(form);
    this.Http.post("http://localhost:8080/questions/createquestion",
    {
      question: form.value.question,
      type: form.value.type,
      answers: form.value.answers,
      possiblePoints: form.value.possiblePoints
    })
    .subscribe({
      next: (data:any)=>{
        //this.router.navigate(['home']);
      },
      //error: (error)=>{
        //console.log(error);
      //},complete: ()=>{}
    })
  }
    

  ngOnInit(): void {
  }

}
