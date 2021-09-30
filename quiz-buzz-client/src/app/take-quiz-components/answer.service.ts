import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Question } from '../models/questions';
import { Quiz } from '../models/quizzes';
import { Answer } from '../models/answers';
import { BehaviorSubject } from 'rxjs';
import { UserScore } from '../models/scores';

@Injectable({
  providedIn: 'root'
})

export class AnswerService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
   
  localStorage: Storage;

  private testUrl: string = "http://localhost:8080/answers/testresults"
  private scoreUrl: string = "http://localhost:8080/test"

  constructor(private http: HttpClient) { 
    this.localStorage = window.localStorage;
  }
  
  // getAllAnswers(): Observable<Answer[]>{
  //   return this.http.get<Answer[]>(`${this.testUrl}`);
  // }

  // getAllQuestions(): Observable<Question[]>{
  //   return this.http.get<Question[]>(`${this.testUrl}`);
  // }

  // getAllQuiz(): Observable<Quiz[]>{
  //   return this.http.get<Quiz[]>(`${this.testUrl}`);
  // }

  // getUserAnswers(key: string): any {
  //   if (this.inStorage) {
  //     return JSON.parse(this.localStorage.getItem(key)||'{}');
  //   }
  //   return null;
  // }
 

  // add(score: UserScore): Observable<UserScore> {
  //   console.log(score);
  //   return this.http.post<UserScore>(this.scoreUrl, score, this.httpOptions);
  // }

  // addScore(score:UserScore): Observable<UserScore> {
  //   const headers = { 'content-type': 'application/json'}  
  //   const body=JSON.stringify(score);
  //   console.log(body)
  //   return this.http.post(this.scoreUrl + 'score', body,{'headers':headers})
  // }

  
  // clear() {
  //   this.answers = [];
  // }

  // private quizSource = new BehaviorSubject<Quiz>({});
  // currentQuiz = this.quizSource.asObservable();

  // private questionSource = new BehaviorSubject<Question>({});
  // currentQuestion = this.questionSource.asObservable();

  // private answerSource = new BehaviorSubject<Answer>({});
  // currentAnswer = this.answerSource.asObservable();
    
  // changeQuiz(currentQuiz: Quiz) {
  //   this.quizSource.next(currentQuiz)
  // }

  // changeQuestion(currentQuestion: Question) {
  //   this.questionSource.next(currentQuestion)
  // }

  // changeAnswer(currentAnswer: Answer) {
  //   this.answerSource.next(currentAnswer)
  // }

}
