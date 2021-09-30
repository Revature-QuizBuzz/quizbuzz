import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-taketest',
  templateUrl: './taketest.component.html',
  styleUrls: ['./taketest.component.css'],

})
export class TaketestComponent implements OnInit {

  counter: number = 0;
  questions: any = [];
  question: any = [];
  answers: any = [];
  correctAnswser: any = [];
  currentQuestion: any;
  selectedAnswer: any = "";
  score: number = 0;
  //quiz id will take you to any test you pick
  quizId: any = localStorage.getItem('quizId');
  isDisable = true;

  // Questions ans Answers from Quizzes
  public url = 'http://localhost:8080/questions/' + this.quizId;



  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {

    this.fetchQuestions();

  }

  submit(testForm: any) {
    //Stores answers into the answers array
    //loops questions and compares them to correct answers
    console.log(this.questions);
    for (let i = 0; i < this.questions.length; i++) {

      this.answers.push(this.questions[i].selectedAnswer);
      console.log(this.answers);
      this.question.push(this.questions[i].question);
      this.correctAnswser.push(this.questions[i].answers[0].answer)
      if (this.questions[i].selectedAnswer === this.questions[i].answers[0].answer) {
        this.score += 1;
        localStorage.setItem('score', this.score.toString())
      }

    }
    //console logs the score and when form is submitted

    console.log("form Sumbitted!");

    //variable for quiz answers to put in local storage

    var quiz_data = this.answers;
    var quiz_question = this.question;
    var quiz_correct = this.correctAnswser;
    //checks to see if the answers array is empyt or even in the local storage then sets the item
    if (localStorage.getItem('answers') == null && localStorage.getItem('question') == null && localStorage.getItem('correctAnswer') == null) {
      localStorage.setItem('answers', '[]');
      localStorage.setItem('question', '[]');
      localStorage.setItem('correctAnswer', '[]');
    }


    //adds new answer to the array then stores it in local storage
    var old_data = "";
    for (let i in quiz_data) {
      old_data += quiz_data[i] + "*";
    }
    localStorage.setItem('answers', old_data);
    //adds new question to the array then stores it in local storage
    var old_question = "";
    for (let i in quiz_question) {
      old_question += quiz_question[i] + "*";
    }
    localStorage.setItem('question', old_question);
    //adds the correct answer to the array in local storage
    var old_correctAnswer = "";
    for (let i in quiz_correct) {
      old_correctAnswer += quiz_correct[i] + "*";
    }
    console.log(old_correctAnswer);
    console.log("here");
    localStorage.setItem('correctAnswer', old_correctAnswer);




    //navigates to the Test Results page
    this.router.navigate(['testresults']);

  }
  //Goes back to previous question 
  previous() {

    if (this.counter - 1 >= 0) {
      this.counter = this.counter - 1;
      this.currentQuestion = this.questions[this.counter];

      if (this.counter != this.questions.length) {
        this.isDisable = true;
      }
    }
  }
  //Goes to the next question 
  next() {

    if (this.counter + 1 < this.questions.length) {
      this.counter = this.counter + 1;
      this.currentQuestion = this.questions[this.counter];

      if ((this.counter + 1) === this.questions.length) {
        this.isDisable = false;
      }

    }
  }

  // Gets the questions and assigns them to the current question variable
  fetchQuestions() {
    this.http.get(this.url).subscribe(data => {
      this.questions = data;
      this.currentQuestion = this.questions[this.counter];
      console.log(this.questions);
    })
  }

  //routs to the home page
  home() {
    this.router.navigate(['home']);
  }
  //Gets answers from selected radio buttons
  getAnswers(e: any) {
    this.currentQuestion.answer = e.target.value;
    this.questions.forEach((q: any) => {
      if (q.questionId === this.currentQuestion.questionId) {
        q.selectedAnswer = e.target.value

      }


    });
  }


}