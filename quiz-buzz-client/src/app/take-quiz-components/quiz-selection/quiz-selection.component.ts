import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quiz-selection',
  templateUrl: './quiz-selection.component.html',
  styleUrls: ['./quiz-selection.component.css']
})
export class QuizSelectionComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  search(){
    console.log("seaching...")
  }

  goToJavaQuizzes(){
    console.log("java")
  }

  goToDatabaseQuizzes(){
    console.log("db")
  }

  goToClientQuizzes(){
    console.log("client")
  }

  startQuiz(){
    console.log("starting quiz...")
    //add routing to 
  }

}
