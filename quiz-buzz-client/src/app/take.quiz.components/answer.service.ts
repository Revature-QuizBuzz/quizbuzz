import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})


@Injectable()
export class AnswerService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
    
  private testUrl: string = "http://localhost:8080/take.quiz.components/taketest"

  answers: string[] = [];
  
  constructor(private http: HttpClient) { }

  getAnswers(){
    return this.http.get(this.testUrl)
  }

  public getAnswers(): Observable<any> {
    // GetAnswers???
    return this.http.get<any>(`${this.baseUrl}/taketest`)
    // const answers = of(this.getAnswers);
    // this.answerService.add('AnswerService: fetched')
    // return answers;
  }

  // add(answers: Answer): Observable<Answer> {
  //   console.log(answers);
  //   return this.http.post<Answer>(this.baseUrl, answers, this.httpOptions);
  // }

  clear() {
    this.answers = [];
  }

  // getAnswer(id: number): Observable<Answer> {
  //   // For now, assume that a hero with the specified `id` always exists.
  //   // Error handling will be added in the next step of the tutorial.
  //   const answer = this.answers.find(a => a.id === id)!;
  //   this.answerService.add(`HeroService: fetched hero id=${id}`);
  //   return of(answer);
  // }

}
