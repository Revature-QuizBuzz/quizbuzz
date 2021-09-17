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

  userId = 0;
  

  constructor(private scoreService: ScoreService) {
  }

  ngOnInit(): void {
    this.seeScoreBoard("pointPercentage")
   
    this.userId = this.getUserId();
    console.log(this.userId);
    
  } 
 

  seeScoreBoard(sort: string): void {
    this.scoreService.displayScoreBoard(sort).subscribe(userScoreboard=>{
      if (sort === "pointPercentage") {
        this.scoreBoard = userScoreboard.sort((a, b) => (a.pointPercentage > b.pointPercentage) ? -1 : 1)
      } else if (sort === "totalPoints") {
        this.scoreBoard = userScoreboard.sort((a, b) => (a.totalPoints > b.totalPoints) ? -1 : 1)
      } 
      console.log(this.scoreBoard)
    })
  }

  getUserId() {
    if(localStorage.getItem("id") === null)
      return 0; 
    return Number(localStorage.getItem("id"))
  }

}

