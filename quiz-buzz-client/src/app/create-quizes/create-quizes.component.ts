import { Component, OnInit } from '@angular/core';
import { Quiz } from '../models/quizzes';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { User } from '../models/users';
import { UserScore } from '../models/scores';
import { Question } from '../models/questions';
import { Tag } from '../models/tags'


const baseUrl = 'http://localhost:8080/quizzes/createQuiz';
// above should be paired with this in controller
// @CrossOrigin(origins = "http://localhost:4200")
// @PostMapping(value="/createQuiz",consumes="application/json")
//     public Quiz create(@RequestBody Quiz quiz){
//         logger.info("created new quiz");
//         return manager.create(quiz);
//     }




@Component({
  selector: 'app-create-quizes',
  templateUrl: './create-quizes.component.html',
  styleUrls: ['./create-quizes.component.css']
})

export class CreateQuizesComponent implements OnInit {

  user: User = {
  }
  quiz: Quiz = {
    id: 0,
    user: this.user,
    scores: [],
    questions: [],
    tags: [],
    name: '',
    description: '',
    totalScore: 0,
  };
  submitted = false;
  createQuiz!: FormGroup;
  // userId: number | null = <number><unknown>localStorage.getItem('userId');
  storageValue: string | null = localStorage.getItem('id');
  userId = JSON.parse(localStorage.getItem('id')|| '{}');




  constructor(private httpClient: HttpClient, private http: HttpClient, private fb: FormBuilder,private modalService: NgbModal) {


  }

  ngOnInit(): void {
    this.createQuiz = this.fb.group({
      quizName: ['', [Validators.required, Validators.maxLength(15)]],
      quizDescription: ['', [Validators.required]],
      temptags: [''],
      questions: this.fb.group({
        // form controll for questions section
      })
    })
  }




  create(quiz: any): Observable<any> {
    return this.http.post(baseUrl, quiz);
  }

  onSubmit({ value, valid }: { value: any, valid: boolean }): void {
    console.log(value, valid);
    let amount: number = 0; // We define 0 as default amount
    if (this.storageValue !== null) {
      amount = parseInt(this.storageValue, 10);
    }
    let user:User = {id:amount};
    this.user = user;
    // this.quiz.userId = amount;
    this.quiz = value;

   // if (confirm("You have succesfully added a new quiz"))
      this.create(value)
        .subscribe(
          response => {
            console.log(response);
            this.submitted = true;
          },
          error => {
            console.log(error);
          });
  }


  addQuestion() {

  }

  add(): void {
    let amount: number = 0; // We define 0 as default amount
    if (this.storageValue !== null) {
      amount = parseInt(this.storageValue, 10);
    }
    let user:User = {id: amount};
    // this.quiz.userId = amount;
    const data = {
      quizId: this.quiz.id,
      user: user,
      // user: this.quiz.userId,
      name: this.quiz.name,
      description: this.quiz.description,
      totalScore: this.quiz.totalScore,
      createdDate: this.quiz.createdDate,
      dateModified: this.quiz.dateModified
    };
    console.log(data)
 //   if(confirm("You have succesfully added a quiz"))
    this.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }


}
