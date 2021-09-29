import { Component, OnInit } from '@angular/core';
import { EditQuizService } from '../services/edit-quiz.service';
import { Quiz } from '../models/quizzes';

@Component({
  selector: 'app-my-quizzes',
  templateUrl: './my-quizzes.component.html',
  styleUrls: ['./my-quizzes.component.css']
})
export class MyQuizzesComponent implements OnInit {

  quizzes:Quiz[] = [];

  constructor(private editQuizService: EditQuizService) { }

  ngOnInit(): void {
    this.getQuizzes();
  }

  getQuizzes() {
    this.editQuizService.getAllQuizzes()
      .subscribe(quizzes => {
        this.quizzes = quizzes;
      })
  }

}
