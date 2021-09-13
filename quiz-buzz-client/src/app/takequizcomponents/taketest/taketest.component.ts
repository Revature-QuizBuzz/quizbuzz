import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';




@Component({
  selector: 'app-taketest',
  templateUrl: './taketest.component.html',
  styleUrls: ['./taketest.component.css'],
 // providers:[TestService]
})
export class TaketestComponent implements OnInit {

  counter:number = 0;
  questions:any = [];
  answers:any = [];
  currentQuestion:any;
  currentAnswer:any;
  idNum:number = 0;
  progressbar:number = 0;
  parsedJson:any;

// // Questions
public urlOne ='http://localhost:8080/questions/1';
public urlTwo ='http://localhost:8080/answers/1'; // Answers

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
  this.fetchQuestions();
   this.fetchAnswers();
   this.currentQuestion = this.questions[this.counter];
   this.currentAnswer = this.answers[this.counter];
   this.parsedJson = JSON.parse(this.currentQuestion);  
    console.log("With Parsed JSON :" , this.parsedJson); 
  }

  submit(){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    
    this.currentQuestion.status="Submit";
    this.idNum = this.currentQuestion.id;
    this.http.post(this.urlOne, this.currentQuestion, httpOptions).subscribe(data=>{
      this.currentAnswer = data;
   })
    
  }
  previous(){
    if(this.counter-1 >= 0){
      this.counter = this.counter - 1;
      this.currentQuestion = this.questions[this.counter];
      this.currentAnswer = this.answers[this.counter];
    }
  }

  next(){
    if(this.counter + 1 < this.questions.length){
      this.counter = this.counter + 1;
      this.currentQuestion = this.questions[this.counter];
      this.currentAnswer = this.answers[this.counter];
    }
  }


  fetchQuestions(){ 
    this.http.get(this.urlOne).subscribe(data=>{
      this.questions = data;
      console.log(data);
      this.currentQuestion = this.questions[0];
    })
  }

  signout(){
    localStorage.clear();
    //this.router.navigate(['']);
  }
  home(){
  //  this.router.navigate(['']);
  }
  
 fetchAnswers(){
    this.http.get(this.urlTwo).subscribe(data=>{
      this.answers = data;
      console.log(data);
      this.currentAnswer = this.answers[0];
    })
  }



}
