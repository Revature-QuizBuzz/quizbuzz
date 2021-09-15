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
  newScores!: UserScore;



  scoreBoard: ScoreBoard[] = [];

  

  constructor(private scoreService: ScoreService) {
  }

  ngOnInit(): void {
    this.seeScore();
  }

  add(inputScore: number): void {
    this.newScores = {
      user: this.users,
      quiz: this.quizzes,
      score: inputScore,
      completedOn: new Date()
    };

    this.scoreService.addScore(this.newScores).subscribe(userScore=>{
      this.newScores = userScore;
    })
  }

  seeScore(): void {
    this.scoreService.displayScore().subscribe(userScoreboard=>{
      this.scoreBoard = userScoreboard;
    })
  }

  onSubmit(f:NgForm) { 
    console.log(f.value['inputScore'])
    this.add(f.value['inputScore']);
    //window.location.reload();
  }

}
