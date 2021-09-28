import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Answer } from '../models/answers';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Quiz } from '../models/quizzes';
import { Question } from '../models/questions';
import { CreateQuizesComponent } from '../create-quizes/create-quizes.component';

@Component({
  selector: 'app-question-answer',
  templateUrl: './question-answer.component.html',
  styleUrls: ['./question-answer.component.css']
})
export class QuestionAnswerComponent implements OnInit {
  answer: Answer={
    answer: "",
    correct: false
  }

  @Input() questionType?: string;
  @Output() answerEvent = new EventEmitter<Answer[]>();
  
  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
  }

  

  onClick(form:NgForm){
    console.log(this.questionType);
    var answerArray = [];
    var answer1 = {};
    var answer2 = {};
    var answer3 = {};
    var answer4 = {};
   answer1 = {
     answer: form.value.answer,
     correct: form.value.correct ? true : false,
   }
   answer2 = {
    answer: form.value.answer2,
    correct: form.value.correct2 ? true : false
  }
  answer3 = {
    answer: form.value.answer3,
    correct: form.value.correct3 ? true : false
  }
  answer4 = {
    answer: form.value.answer4,
    correct: form.value.correct4 ? true : false
  }
  answerArray.push(answer1);
  answerArray.push(answer2);
  answerArray.push(answer3);
  answerArray.push(answer4);
    console.log(answer1)
    console.log(answer2)
    console.log(answer3)
    console.log(answer4);
    console.log(answerArray);
  this.answerEvent.emit(answerArray);
  //     this.http.post(this._url,
  //       answerArray,httpOptions
  //       ).subscribe({
  //         next: (data:any)=>{
  //           if(data.status === 'success'){
  //             this.router.navigate(['newquestion'])
  //           }
  //         }
  //       })
  // }
  }
}
