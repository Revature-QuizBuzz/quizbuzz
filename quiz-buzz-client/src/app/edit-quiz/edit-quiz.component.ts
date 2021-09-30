import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { NgForm } from '@angular/forms';

import { Quiz} from '../models/quizzes';
import { Question } from '../models/questions';
import { Answer } from '../answer';

import { QuizService } from '../services/quiz.service';

@Component({
  selector: 'app-edit-quiz',
  templateUrl: './edit-quiz.component.html',
  styleUrls: ['./edit-quiz.component.css']
})
export class EditQuizComponent implements OnInit {

  constructor(private quizService: QuizService,
      private route: ActivatedRoute,
      private location: Location)  
      { }

  editQuizModel: Quiz = {}
  numOfQues: Number = 0
  questions: Question[] = []
  answers: Answer[] = []
  answer: Answer = {
    id:0,
    answer: "",
    correct: false
  }
  questionModel: Question = {}
  types: String[] = ["Multiple Choice", "Multiple Answer", "True or False"]

  ngOnInit(): void {
    this.getUserQuiz()
  }

  getUserQuiz() {
    const quizName = this.route.snapshot.paramMap.get('name') || ""

    this.quizService.getQuizByUserIdAndName(quizName)
     .subscribe(quiz => {
       this.editQuizModel = quiz;
       if (quiz.questions) {
        this.questions = quiz.questions
       }
     })
  }

  checkSelect(thisType: String, qType: String) {
    if(qType == thisType) {
      return "selected"
    }
    else {
      return ""
    }
  }

  onSubmit(editQuizForm: NgForm) {

  }

}
