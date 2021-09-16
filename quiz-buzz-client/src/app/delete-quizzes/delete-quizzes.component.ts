import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-delete-quizzes',
  templateUrl: './delete-quizzes.component.html',
  styleUrls: ['./delete-quizzes.component.css']
})
export class DeleteQuizzesComponent implements OnInit {

  errorMessage = "";

  constructor(
    private quizService: QuizService,
    private router: Router
    ) { }

  ngOnInit(): void {
  }

  deleteQuiz(quizId: number): void {
    // let quizIdentifier = quizId;
    this.quizService.deleteQuiz(quizId)
      .subscribe(r => {
        if (r.status == 200) {
          //Return to the previous page.
          //Quizzes page does not exist.
          this.router.navigate(['/quizzes']);
        }
      });
  }

  
}
