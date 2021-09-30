import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DeleteQuizzesComponent } from './delete-quizzes/delete-quizzes.component';
import { Quiz } from './models/quizzes';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private baseUrl = "http://localhost:8080/quizzes"

  constructor(private http: HttpClient) { 

    

    // updateProductStock(stock: Stocks): Observable<Product> {
    //   return this.http.post<Product>(this.baseUrl, stock, this.httpOptions);
    // }
  }

  deleteQuiz(quizId: number): Observable<string> {
    return this.http.delete<string>(this.baseUrl + "/" + quizId);
  }

  getQuizzesByUserId(userId: number): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(`${this.baseUrl}/user/${userId}`);
  }
}
