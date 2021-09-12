import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Question } from '../models/questions';
import { Quiz } from '../models/quizzes';
import { Answer } from '../models/answers';

@Injectable({
  providedIn: 'root'
})

export class AnswerService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
    
  private testUrl: string = "http://localhost:8080/testresults"
  
  constructor(private http: HttpClient) { }

  getAllQuiz(): Observable<Quiz[]>{
    return this.http.get<Quiz[]>(`${this.testUrl}`);
  }

  getAllAnswers(): Observable<Answer[]>{
    return this.http.get<Answer[]>(`${this.testUrl}`);
  }

  getAllQuestions(): Observable<Question[]>{
    return this.http.get<Question[]>(`${this.testUrl}`);
  }
  // getAnswer(id: number): Observable<Answer> {
  //   const answer = this.answers.find(a => a.id === id)!;
  //   this.answerService.add(`answerService: fetched answer id=${id}`);
  //   return of(answer);
  // }

  public getAnswers(): Observable<any> {
    // GetAnswers???
    return this.http.get<any>(`${this.testUrl}/taketest`)
    // const answers = of(this.getAnswers);
    // this.answerService.add('AnswerService: fetched')
    // return answers;
  }

  // add(answers: Answer): Observable<Answer> {
  //   console.log(answers);
  //   return this.http.post<Answer>(this.baseUrl, answers, this.httpOptions);
  // }

  // clear() {
  //   this.answers = [];
  // }

}
