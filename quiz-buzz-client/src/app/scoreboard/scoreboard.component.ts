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
    this.testId = 1;
    this.seeScoreBoard("pointPercentage")
  }
    

  onClick(sort: string): void {
    this.seeScoreBoard(sort)
  }
 

  seeScoreBoard(sort: string): void {
    this.scoreService.displayScoreBoard(sort).subscribe(userScoreboard=>{
      if (sort === "pointPercentage") {
        this.scoreBoard = userScoreboard.sort((a, b) => (a.pointPercentage > b.pointPercentage) ? -1 : 1)
      } else if (sort === "totalPoints") {
        this.scoreBoard = userScoreboard.sort((a, b) => (a.totalPoints > b.totalPoints) ? -1 : 1)
      } 
      
    })
  }


}

