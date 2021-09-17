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
  filteredQuizzes:any = [];

  public getUrl = 'http://localhost:8080/quizzes'

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    this.fetch();
  }

  search(){
    //console.log("seaching...")
    var searchValue = (document.getElementById('searchBar') as HTMLInputElement).value;
    console.log(searchValue)

    

    console.log(this.filteredQuizzes.length)

    let filteredQuizzes = this.quizzes.filter(function (quiz:any){ return quiz.name === searchValue}).map(function (quiz:any){return quiz.name})

    console.log(filteredQuizzes[0].totalScore)

    //1. filter
    //this.filteredQuizzes = this.quizzes.name.filter((q: string | string[]) => q.includes(searchValue))

    //2. triple for loop checking each value
    // for(let i = 0; i < this.quizzes.length; i++){
    //   for(let j = 0; j < this.quizzes[i].name.length; j++){
    //     console.log(this.quizzes[i].name[j])
    //     for(let l = 0; l < searchValue.length; l++){
    //       if(this.quizzes[i].name[j] == searchValue[l]){
    //         this.filteredQuizzes.push(this.quizzes[i])
    //         i++;
    //       }
    //     }
    //   }
    // }
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
function quiz(quiz: any, arg1: (any: any) => void) {
  throw new Error('Function not implemented.');
}

