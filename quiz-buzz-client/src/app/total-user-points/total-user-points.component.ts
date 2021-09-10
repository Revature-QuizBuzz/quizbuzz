import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ScoreService } from '../score.service';
import { UserScore } from '../models/scores';


@Component({
  selector: 'app-total-user-points',
  templateUrl: './total-user-points.component.html',
  styleUrls: ['./total-user-points.component.css']
})
export class TotalUserPointsComponent implements OnInit {


  scores: UserScore[] = [];
  newScores: UserScore = {
    userId: 1,
    scoreId: 1,
    quizId: 1,
    score: 90,
    completedOn: new Date()
  };

  constructor(private scoreService: ScoreService) {}

  ngOnInit(): void {
  }

  add(userScore: UserScore): void {
    this.scoreService.addScore(userScore).subscribe(userScore=>{
      console.log(userScore);
    })
  }

  onSubmit(form:NgForm) { 
    this.add(this.newScores);

  }

}
