import { Component, OnInit } from '@angular/core';
import { ScoreService } from '../score.service';
import { ScoreBoard } from '../models/scoreboard';


@Component({
  selector: 'app-scoreboard',
  templateUrl: './scoreboard.component.html',
  styleUrls: ['./scoreboard.component.css']
})
export class ScoreBoardComponent implements OnInit {
  
  scoreBoard: ScoreBoard[] = [];

  testId = 0;
  userId = 0;
  

  constructor(private scoreService: ScoreService) {
  }

  ngOnInit(): void {
    this.seeScoreBoard();
  }
    

  seeScoreBoard(): void {
    this.scoreService.displayScore().subscribe(userScoreboard=>{
      this.scoreBoard = userScoreboard;
    })
  }


}

