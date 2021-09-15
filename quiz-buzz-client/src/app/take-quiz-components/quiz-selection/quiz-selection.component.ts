import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-quiz-selection',
  templateUrl: './quiz-selection.component.html',
  styleUrls: ['./quiz-selection.component.css']
})
export class QuizSelectionComponent implements OnInit {

  quizzes:any = [];

  public getUrl = 'http://localhost:8080/quizzes'

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    this.fetch();
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
    this.router.navigate(["take/quiz"])
  }

  fetch(){
    const httpOptions = {
    headers: new HttpHeaders({
     'Content-Type':  'application/json'})}

    this.http.get(this.getUrl, httpOptions).subscribe(data=>{
      this.quizzes= data;
      console.log(data)
    })
   }

}
