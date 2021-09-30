import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CreatedQuizzesComponent } from '../created-quizzes/created-quizzes.component';
import { QuizService } from '../quiz.service';

@Component({
  selector: 'app-edit-quiz',
  templateUrl: './edit-quiz.component.html',
  styleUrls: ['./edit-quiz.component.css']
})
export class EditQuizComponent implements OnInit {

  @Input('selectedQuiz') editQuiz = '';

  constructor(private router: Router, private http: HttpClient) { }

  public url = 'http://localhost:8080/questions/' + this.quizId;

  ngOnInit(): void {
  }

  fetchQuestions() {
    this.http.get(this.url).subscribe(data => {
      this.questions = data;
      this.currentQuestion = this.questions[0];
    })
  }
}
