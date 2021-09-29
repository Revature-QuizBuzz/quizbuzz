import { Component, OnInit } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { EditQuizService } from '../services/edit-quiz.service';
import { Quiz } from '../models/quizzes';

@Component({
  selector: 'app-edit-quiz',
  templateUrl: './edit-quiz.component.html',
  styleUrls: ['./edit-quiz.component.css']
})
export class EditQuizComponent implements OnInit {


  quiz:Quiz = {
    scores: [],
    questions: [],
    tags: [],
    name: "",
    description: "",
    totalScore: 0,
    dateModified: new Date()
  }

  constructor(
    private route: ActivatedRoute, //holds information about the route of the component
    private editQuizService: EditQuizService, // this gets data from our server
    private location: Location // this helps us navigate to the previous page. see goBack()
  ) { }

  ngOnInit(): void {
    this.quizHandler();
  }


  //
  quizHandler() {
    const quizId: number = Number(this.route.snapshot.paramMap.get('id'));

    this.editQuizService.getQuiz(quizId)
    .subscribe(
      quiz => 
      {
        this.quiz = quiz;
      }
    )
  }

}
