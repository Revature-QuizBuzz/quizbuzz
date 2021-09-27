import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import { NgForm } from '@angular/forms';





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
  selectedAnswer:string[] =[];
  idNum:number = 0;
  score:number = 0;
   
 
// // Questions
public urlOne ='http://localhost:8080/questions/1';
public urlTwo ='http://localhost:8080/answers/1'; // Answers
public testUrl = 'http://localhost:8080/testanswers/create'; //pushing answers to db

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
   
  this.fetchQuestions();
  this.selectedAnswer = new Array<string>();
  this.currentQuestion = this.questions[this.counter];
  
   
  }

  submit(testForm: any){
    console.log("form Sumbitted!");
    var quiz_data = this.selectedAnswer;
    if(localStorage.getItem('answers')== null){
      localStorage.setItem('answers','[]');
    }
    
    var old_data  = JSON.parse(localStorage.getItem('answers')||'{}');
    old_data.push(quiz_data);
    JSON.stringify(old_data);
    localStorage.setItem('answers', old_data);
    
    console.log(this.currentQuestion.correct + "right answers");
 
  }

  previous(){
    
    if(this.counter-1 >= 0){
      this.counter = this.counter - 1;
      this.currentQuestion = this.questions[this.counter];
  
    }
  }

  next(){
    
    if(this.counter + 1 < this.questions.length){
      this.counter = this.counter + 1;
      this.currentQuestion = this.questions[this.counter];
     
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

  getAnswers(e:any,answer:string){

    if(e.target.checked){
      console.log(answer + ' Checked ');
      this.selectedAnswer.push(answer);
    }
    else{
     
      this.selectedAnswer = this.selectedAnswer.filter((m)=>m!=answer);
      console.log(answer);
    }
    console.log(this.selectedAnswer);
  }
 

}