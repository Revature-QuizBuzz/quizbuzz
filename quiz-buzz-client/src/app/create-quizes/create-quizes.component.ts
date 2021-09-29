import { Component, OnInit, ViewChild } from '@angular/core';
import { Quiz } from '../models/quizzes';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { User } from '../models/users';
import { UserScore } from '../models/scores';
import { Question } from '../models/questions';
import { Tag } from '../models/tags';
import { Router } from '@angular/router';   


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

  user: User = {}
  quiz: Quiz = {
    quizId: 0,
    user: this.user,
    scores: [],
    questions: [],
    tags: [],
    name: '',
    description: '',
    totalScore: 0,
  };

  submitted = false;
  saved = false;
  moreQuestions = false;
  createQuiz!: FormGroup;
  // userId: number | null = <number><unknown>localStorage.getItem('userId');
  storageValue: string | null = localStorage.getItem('id');
  userId = JSON.parse(localStorage.getItem('id')|| '{}');
  numQuestions: any;




  constructor(private router: Router, private httpClient: HttpClient, private http: HttpClient, private fb: FormBuilder,private modalService: NgbModal) {

  }

  ngOnInit(): void {
    this.createQuiz = this.fb.group({
      quizName: ['', [ Validators.maxLength(15), Validators.required]],
      quizDescription: ['', [Validators.required]],
      temptags: [''],
      questionArray: this.fb.array([this.fb.group({
        // form controll for questions section
        questions: ['']
      })
      ])
    })
  }

  recieveQuestion($event: Question[]) {
    this.addQuestion($event);
    console.log(this.quiz);
    this.numQuestions++;
  }

  public addQuestion(question : Question[]){
    this.quiz.questions = question;
  }

  create(quiz: any): Observable<any> {
    return this.http.post(baseUrl, quiz);
  }

  onSubmit(){
    console.log(this.createQuiz);
    let amount: number = 0; // We define 0 as default amount
    if (this.storageValue !== null) {
      amount = parseInt(this.storageValue, 10);
    }

    this.quiz.user = { userId: amount };
    this.quiz.name = this.createQuiz.value.quizName;
    this.quiz.description = this.createQuiz.value.quizDescription;
    // this.quiz.tags = this.createQuiz.value.temptags;
    // this.quiz.questions = this.createQuiz.value.questionArray;
    // console.log(this.quiz)
    // if (confirm("You have succesfully added a new quiz"))
    if (this.saved == false) {
      alert("Please save your progress before submitting!");
      return;
    }
    this.create(this.quiz)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
    if (this.saved == true) {
      this.router.navigate(['home']);
      }
    
  }

  selectedTags($event:any) {
    this.quiz.tags = $event; 
    console.log($event);
  }


  public deleteQuestion(index : number){
    if(this.quiz.questions![index] !== null || undefined)
    delete this.quiz.questions![index];
  }

  public save(){
    this.saved = true;
  }

  public count(){
    let result = '';
    let i = 0;

    do {
      
      i = i + 1;
      result = result + i;
    } while (i < 5);

    console.log(result);

      }


  // Used for bubbling data and adding Tags to the quiz 
  public addTag(tag: Tag[]) {
    tag.forEach(element => {
      this.quiz.tags?.push(element);
    });
  }



}
