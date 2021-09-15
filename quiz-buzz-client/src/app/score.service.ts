import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserScore } from '../app/models/scores';
import { ScoreBoard } from './models/scoreboard';

@Injectable({
  providedIn: 'root' 
})
export class ScoreService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  private apiUrl: string = "http://localhost:8080"

  constructor(private http: HttpClient) { }

  // Total Scores
  addScore(score: UserScore): Observable<UserScore> {
    console.log(score);
    const scoresURL = `${this.apiUrl}/scores`
    return this.http.post<UserScore>(scoresURL, score, this.httpOptions);
  }

  // Display Scores
  displayScore(): Observable<ScoreBoard[]> {
    return this.http.get<ScoreBoard[]>(`${this.apiUrl}/scoreboard`);
  }
}
