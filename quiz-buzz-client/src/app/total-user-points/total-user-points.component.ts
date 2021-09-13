import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ScoreService } from '../score.service';
import { UserScore } from '../models/scores';
import { User } from '../models/users';
import { Quiz } from '../models/quizzes';
import { ScoreBoard } from '../models/scoreboard';


@Component({
  selector: 'app-total-user-points',
  templateUrl: './total-user-points.component.html',
  styleUrls: ['./total-user-points.component.css']
})
export class TotalUserPointsComponent implements OnInit {

  users: User = {"id":1};
  quizzes: Quiz = {"id":1};
  scores: UserScore[] = [];

  scoreBoard: ScoreBoard[] = [];

  newScores: UserScore = {
    user: this.users,
    quiz: this.quizzes,
    score: 90,
    completedOn: new Date()
  };

  constructor(private scoreService: ScoreService) {}

  ngOnInit(): void {
    this.seeScore();
  }

  add(userScore: UserScore): void {
    this.scoreService.addScore(userScore).subscribe(userScore=>{
      console.log(userScore);
    })
  }

  seeScore(): void {
    this.scoreService.displayScore().subscribe(userScoreboard=>{
      this.scoreBoard = userScoreboard;
    })
  }

  onSubmit(form:NgForm) { 
    this.add(this.newScores);
    window.location.reload();
  }

}
