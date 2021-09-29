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
  question:any = [];
  answers:any = [];
  correctAnswser:any =[]; 
  currentQuestion:any;
  selectedAnswer:any ="";
  score:number=0;
  //quiz id will take you to any test you pick
  quizId:any = localStorage.getItem('quizId');
   isDisable = true;

// Questions ans Answers from Quizzes
public url ='http://localhost:8080/questions/'+this.quizId;

 

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
   
  this.fetchQuestions();
 
  }

  submit(testForm: any){
//Stores answers into the answers array
//loops questions and compares them to correct answers
for(let i in this.questions){
 
  this.answers.push(this.questions[i].selectedAnswer);
  this.question.push(this.questions[i].question);
  this.correctAnswser.push(this.questions[i].answers[0].answer)
  if(this.questions[i].selectedAnswer === this.questions[i].answers[0].answer ){
    this.score +=1;
    localStorage.setItem('score', this.score.toString())
  }
  console.log("look here")
  console.log(this.questions[i].selectedAnswer)
  console.log(this.questions[i].answers[0].correct)
}
//console logs the score and when form is submitted
  console.log( " this is your score " + this.score);
  console.log("form Sumbitted!");
//variable for quiz answers to put in local storage
// console.log(this.answers);
// console.log('this is answers')
  var quiz_data =  this.answers;
  var quiz_question = this.question;
  var quiz_correct = this.correctAnswser;
  //checks to see if the answers array is empyt or even in the local storage then sets the item
  if(localStorage.getItem('answers') == null && localStorage.getItem('question') == null && localStorage.getItem('correctAnswer')== null){
    localStorage.setItem('answers','[]');
    localStorage.setItem('question','[]');
    localStorage.setItem('correctAnswer','[]');  
  }

 
  //adds new answer to the array then stores it in local storage
  var old_data  = JSON.parse(localStorage.getItem('answers')||'{}');
  // this.answers.forEach(this.answers, function(item, i) {
  //   if (item.id === '100033') {
  //   }
  // });
  old_data.push(quiz_data);
 // JSON.stringify(old_data);
  localStorage.setItem('answers', old_data);
//adds new question to the array then stores it in local storage
  var old_question = JSON.parse(localStorage.getItem('question')||'{}');
  old_question.push(quiz_question);
 // JSON.stringify(old_question);
  localStorage.setItem('question',old_question);
//adds the correct answer to the array in local storage
  var old_correctAnswer = JSON.parse(localStorage.getItem('correctAnswer')||'{}');
  old_correctAnswer.push(quiz_correct);
 // JSON.stringify(old_correctAnswer);
  localStorage.setItem('correctAnswer',old_correctAnswer);



console.log(localStorage.getItem('answers'))
//console.log(localStorage.getItem('question'))
//console.log(localStorage.getItem('correctAnswer'))

  //navigates to the Test Results page
  //this.router.navigate(['testresults']);
  
  }
//Goes back to previous question 
  previous(){
    
    if(this.counter-1 >= 0){
      this.counter = this.counter - 1;
      this.currentQuestion = this.questions[this.counter];
      
      if(this.counter != this.questions.length){
        this.isDisable = true;
      }
    }
  }
//Goes to the next question 
  next(){
    
    if(this.counter + 1 < this.questions.length){
      this.counter = this.counter + 1;
      this.currentQuestion = this.questions[this.counter];
  
     if((this.counter + 1) === this.questions.length){
       this.isDisable=false;
     }
 
    }
  }

// Gets the questions and assigns them to the current question variable
  fetchQuestions(){ 
    this.http.get(this.url).subscribe(data=>{
      this.questions = data;
      this.currentQuestion = this.questions[this.counter];
    })
  }
//clears out local storage and routs to login page
  signout(){
   delete localStorage['answers'];
   delete localStorage['question'];
   delete localStorage['correctAnswer'];
   delete localStorage['score'];
   // this.router.navigate(['']);
  }
//routs to the home page
  home(){
   this.router.navigate(['home']);
  }
//Gets answers from selected radio buttons
  getAnswers(e:any){        
      this.currentQuestion.answer = e.target.value;
      this.questions.forEach((q:any) => {
       if( q.questionId === this.currentQuestion.questionId){
         q.selectedAnswer = e.target.value
        
       }  
       
      
      });
  }


}