import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-delete-quizzes',
  templateUrl: './delete-quizzes.component.html',
  styleUrls: ['./delete-quizzes.component.css']
})
export class DeleteQuizzesComponent implements OnInit {

  quizzes:any = [];
  filteredQuizzes:any = [];
  selectedQuiz:any = '';
  searchValue:any = '';
  errorMessage = "";

  public getUrl = 'http://localhost:8080/quizzes'
  public searchQuizzesUrl = 'http://localhost:8080/quizzes/search/'

  constructor(private router:Router, private http:HttpClient, private quizService: QuizService) { }

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


  startQuiz(){
    localStorage.setItem("quizId", this.selectedQuiz.quizId)
   
    console.log(this.selectedQuiz.quizId)
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

   deleteQuiz(quizId: number): void {
    // let quizIdentifier = quizId;
    this.quizService.deleteQuiz(quizId)
      .subscribe(r => {
        
          //Return to the previous page.
          //Quizzes page does not exist.
          this.selectedQuiz = '';
          this.fetch();
  
      });
  }
  
}
