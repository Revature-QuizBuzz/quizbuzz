import { Component, OnInit } from '@angular/core';
import { Quiz } from '../models/quizzes';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
const baseUrl = 'http://localhost:8080/quizzes/createQuiz';

@Component({
  selector: 'app-create-quizes',
  templateUrl: './create-quizes.component.html',
  styleUrls: ['./create-quizes.component.css']
})
export class CreateQuizesComponent implements OnInit {
  quizes?: Quiz[];
  addQuiz: Quiz = {
    name: ''
  };
  submitted = false;

  constructor(private httpClient: HttpClient,private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllQuizes();
  }

  getAllQuizes(){
    this.httpClient.get<any>('http://localhost:8080/quizzes').subscribe(
      response => {
        console.log(response);
        this.quizes = response;
      }
    );
  }

  create(prodId:any, data:any): Observable<any> {
    return this.http.post(baseUrl + "/" + prodId, data);
  }

  add(): void {
    const userId = this.addQuiz.userId;
    const data = {
      quizId: this.addQuiz.quizId,
      name: this.addQuiz.name,
      description: this.addQuiz.description,
      totalScore: this.addQuiz.totalScore,
      createdDate: this.addQuiz.createdDate,
      dateModified: this.addQuiz.dateModified
    };
    if(confirm("You have succesfully added a new quiz"))
    this.create(userId, data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  // incase we want to pass date more neatly
  // formatDate(date:any) {
  //   let d = new Date(date);
  //   return d.getMonth() + "/" + d.getDate() + "/" + d.getFullYear();
  // }

}
