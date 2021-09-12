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
    var answerArray = [];
    var answer1 = {};
    var answer2 = {};
    var answer3 = {};

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
   answer1 = {
     questionid: form.value.questionid,
     answer: form.value.answer1,
     correct: form.value.correct1
   }
   answer2 = {
    questionid: form.value.questionid,
    answer: form.value.answer2,
    correct: form.value.correct2
  }
  answer3 = {
    questionid: form.value.questionid,
    answer: form.value.answer3,
    correct: form.value.correct3
  }
  answerArray.push(answer1);
  answerArray.push(answer2);
  answerArray.push(answer3);
    console.log(form.value.questionid)
    console.log(form.value.answer)
    console.log(form.value.correct)
    console.log(this.answer.correct)
      this.http.post(this._url,
        answerArray,httpOptions
        ).subscribe({
          next: (data:any)=>{
            if(data.status === 'success'){
              this.router.navigate(['newquestion'])
            }
          }
        })
  }

}
