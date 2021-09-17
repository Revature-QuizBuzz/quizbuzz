import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Question } from '../models/questions';
import { Quiz } from '../models/quizzes';
import { Answer } from '../models/answers';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AnswerService {

  private testUrl: string = "http://localhost:8080/answers/testresults"
  
  constructor(private http: HttpClient) { }

  getAllAnswers(): Observable<Answer[]>{
    return this.http.get<Answer[]>(`${this.testUrl}`);
  }

  getAllQuestions(): Observable<Question[]>{
    return this.http.get<Question[]>(`${this.testUrl}`);
  }

  getAllQuiz(): Observable<Quiz[]>{
    return this.http.get<Quiz[]>(`${this.testUrl}`);
  }

  // getAnswer(id: number): Observable<Answer> {
  //   const answer = this.answers.find(a => a.id === id)!;
  //   this.answerService.add(`answerService: fetched answer id=${id}`);
  //   return of(answer);
  // }

  // add(answers: Answer): Observable<Answer> {
  //   console.log(answers);
  //   return this.http.post<Answer>(this.baseUrl, answers, this.httpOptions);
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
