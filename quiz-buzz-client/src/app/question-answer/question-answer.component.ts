import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Answer } from '../answer';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-question-answer',
  templateUrl: './question-answer.component.html',
  styleUrls: ['./question-answer.component.css']
})
export class QuestionAnswerComponent implements OnInit {

  answer: Answer={
    id: 0,
    answer: "",
    correct: false
  }
  constructor(private http:HttpClient, private router:Router) { }

  public _url = "http://localhosst:8080/answer/answerstoquestion"

  ngOnInit(): void {
  }
  onSubmit(form:NgForm){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    console.log(form.value.questionid)
    console.log(form.value.answer)
    console.log(form.value.correct)
      this.http.post(this._url,
        JSON.stringify({
          questionid: form.value.questionid,
          answer: form.value.answer,
          correct: form.value.correct
        }),httpOptions
        ).subscribe({
          next: (data:any)=>{
            if(data.status === 'success'){
              this.router.navigate(['newquestion'])
            }
          }
        })
  }

}
