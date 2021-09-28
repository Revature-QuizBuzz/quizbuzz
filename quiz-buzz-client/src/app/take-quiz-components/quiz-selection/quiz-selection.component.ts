import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quiz } from 'src/app/models/quizzes';

@Component({
  selector: 'app-quiz-selection',
  templateUrl: './quiz-selection.component.html',
  styleUrls: ['./quiz-selection.component.css']
})
export class QuizSelectionComponent implements OnInit {

  quizzes:Quiz[] = [];
  filteredQuizzes:Quiz[] = [];
  selectedQuiz:any = '';
  searchValue:any = '';

  public getUrl = 'http://localhost:8080/quizzes'
  public searchQuizzesUrl = 'http://localhost:8080/quizzes/search/'

  constructor(private router:Router, private http:HttpClient) { }

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
        this.http.get(this.searchQuizzesUrl+this.searchValue, httpOptions).subscribe({
          next: (data:any) =>{
            this.filteredQuizzes= data;
            console.log(data)
          }
        })
      }

  }

  selectQuiz(quiz:any){
    //var quiz = document.getElementById("quizName")?.innerHTML.trim()
    this.selectedQuiz = quiz;
  }

  getQuizLength() {
    if( this.quizzes !== undefined && this.quizzes !== null)
      return this.quizzes.length;
    return 0;
  }

  startQuiz(){
    localStorage.setItem("quizId", this.selectedQuiz.quizId)
    this.router.navigate(["take/quiz"])
  }

  fetch(){
    const httpOptions = {
    headers: new HttpHeaders({
     'Content-Type':  'application/json'})}

    this.http.get(this.getUrl, httpOptions).subscribe({
      next: (data:any) =>{
      this.quizzes= data;
      console.log(data)
      }
    })
   }

}
function quiz(quiz: any, arg1: (any: any) => void) {
  throw new Error('Function not implemented.');
}