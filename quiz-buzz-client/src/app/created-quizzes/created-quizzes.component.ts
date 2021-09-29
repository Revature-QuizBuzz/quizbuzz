import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { QuizService } from '../quiz.service';
import { Quiz } from '../models/quizzes';

@Component({
  selector: 'app-created-quizzes',
  templateUrl: './created-quizzes.component.html',
  styleUrls: ['./created-quizzes.component.css']
})
export class CreatedQuizzesComponent implements OnInit {

  quizzes:any = [];
  filteredQuizzes:any = [];
  selectedQuiz:any = '';
  searchValue:any = '';

  public getUrl = 'http://localhost:8080/quiz/created-quizzes'
  public searchQuizzesUrl = 'http://localhost:8080/quiz/created-quizzes/search/'

  constructor(private router:Router, private http:HttpClient, private quizService:QuizService ) { }

  ngOnInit(): void {
    this.fetch();
  }

  search(){
    this.searchValue = (document.getElementById('searchBar') as HTMLInputElement).value;
    console.log(this.searchValue)

    const httpOptions = {
      headers: new HttpHeaders({
       'Content-Type':  'application/json'})}
      
      console.log(this.searchQuizzesUrl+this.searchValue)
      if(this.searchValue != '')
      {
        this.http.get(this.searchQuizzesUrl+this.searchValue, httpOptions).subscribe(data=>{
        this.filteredQuizzes= data;
        console.log(data)
        })
      }

  }

  selectQuiz(quiz:any){
    //var quiz = document.getElementById("quizName")?.innerHTML.trim()
    this.selectedQuiz = quiz;
  }

  fetch(): void{
    this.quizService.getQuizzes().subscribe(allQuizzes => {
      this.quizzes = allQuizzes;
    })
  }

  editQuiz(){
    console.log(this.selectedQuiz)
  }
}
