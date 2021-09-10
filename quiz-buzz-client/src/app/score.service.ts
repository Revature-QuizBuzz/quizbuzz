import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserScore } from '../app/models/scores';

@Injectable({
  providedIn: 'root' 
})
export class ScoreService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  private apiUrl: string = "http://localhost:8080/scores"

  constructor(private http: HttpClient) { }

  // Total Scores
  addScore(score: UserScore): Observable<UserScore> {
    console.log(score);
    return this.http.post<UserScore>(this.apiUrl, score, this.httpOptions);
  }
}
