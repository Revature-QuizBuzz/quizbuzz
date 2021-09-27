import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-taketest',
  templateUrl: './taketest.component.html',
  styleUrls: ['./taketest.component.css'],
 
})
export class TaketestComponent implements OnInit {

  counter:number = 0;
  questions:any = [];
  answers:any = [];
  correctAnswser:any =[]; 
  currentQuestion:any;
  selectedAnswer:any ="";
  score:number=0;
  //quiz id will take you to any test you pick
  quizId:any;

// Questions ans Answers from Quizzes
public url ='http://localhost:8080/questions/1';

 

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
   
  this.fetchQuestions();
  this.currentQuestion = this.questions[this.counter];
  
   
  }

  submit(testForm: any){
//Stores answers into the answers array
//loops questions and compares them to correct answers 
for(let i in this.questions){
  this.answers.push(this.questions[i].selectedAnswer);
  if(this.questions[i].selectedAnswer === this.questions[i].answers[0].answer ){
    this.score +=1;
  }
  
}
//console logs the score and when form is submitted
  console.log( " this is your score " + this.score);
  console.log("form Sumbitted!");
//variable for quiz answers to put in local storage
  var quiz_data =  this.answers;
  //checks to see if the answers array is empyt or even in the local storage then sets the item
  if(localStorage.getItem('answers')== null){
    localStorage.setItem('answers','[]');
  }
  //adds new answer to the array then stores it in local storage
  var old_data  = JSON.parse(localStorage.getItem('answers')||'{}');
  old_data.push(quiz_data);
  JSON.stringify(old_data);
  localStorage.setItem('answers', old_data);
  //navigates to the Test Results page
  this.router.navigate(['testresults']);
  }
//Goes back to previous question 
  previous(){
    
    if(this.counter-1 >= 0){
      this.counter = this.counter - 1;
      this.currentQuestion = this.questions[this.counter];
  
    }
  }
//Goes to the next question 
  next(){
    
    if(this.counter + 1 < this.questions.length){
      this.counter = this.counter + 1;
      this.currentQuestion = this.questions[this.counter];
     
    }
  }

// Gets the questions and assigns them to the current question variable
  fetchQuestions(){ 
    this.http.get(this.url).subscribe(data=>{
      this.questions = data;
      this.currentQuestion = this.questions[0];
    })
  }
//clears out local storage and routs to login page
  signout(){
    localStorage.clear();
    this.router.navigate(['']);
  }
//routs to the home page
  home(){
   this.router.navigate(['home']);
  }
//Gets answers from selected radio buttons
  getAnswers(e:any){        
      this.currentQuestion.answer = e.target.value;
      this.questions.forEach((q:any) => {
       if( q.id === this.currentQuestion.id){
         q.selectedAnswer = e.target.value 
       }  
      });
  }

}