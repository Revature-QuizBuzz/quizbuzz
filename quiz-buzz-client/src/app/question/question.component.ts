import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms'
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CreateQuizesComponent } from '../create-quizes/create-quizes.component';
import { Question } from '../models/questions';
import { Quiz } from '../models/quizzes';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  selectedType = "";
  questions: Question[] = [];
  questionForm!: FormGroup;
  isSubmitted?: false;
  questionMap = new Map<number,number>();
  questionCount: number = 0;
  dummyQuestion: Question = {
    id: 0,
    question: "",
    possiblePoints: 0,
    type: "",
  }

  @Output() questionEvent = new EventEmitter<Question[]>();

  constructor(private router: Router, private http: HttpClient, private formBuilder: FormBuilder) { }

  public _url = "http://localhost:8080/questions/new"

  ngOnInit(): void {
    this.questions.push( this.dummyQuestion);
    this.questionForm = this.formBuilder.group({
      questionName: ['', Validators.required],
      possiblePoints: ['', Validators.required],
      questionType: ['', Validators.required]
    })
  }

  onChange(selectedType: string) {
    console.log(selectedType);
    this.selectedType = selectedType;
  }

  onSubmit() {

    let question: Question = {
      id: 0,
      question: "",
      possiblePoints: 0,
      type: "",
    }

    question.question = this.questionForm.value.questionName;
    question.possiblePoints = this.questionForm.value.possiblePoints;
    question.type = this.questionForm.value.questionType;
    console.log(question);
    this.questions.push(question);
    this.questionEvent.emit(this.questions);
    this.questionMap.set(this.questionCount,this.questions.indexOf(question));
    this.questionCount++;
    this.questions.push(this.dummyQuestion)
    this.questionForm.reset();

    // const httpOptions = {
    // headers: new HttpHeaders({'Content-Type':'application/json'})}
    // let quiz: Quiz ={id:stockForm.value.quizid}
    // this.http.post(this._url,({ 
    //   quiz:quiz, 
    //   question:stockForm.value.question, 
    //   possiblePoints:stockForm.value.possiblePoints, 
    //   type:stockForm.value.type, 
    // }), httpOptions
    // ).subscribe({
    //   next: (data) => {
    //     console.log(data)
    //   }
    // })
    // this.router.navigate([""])

  }

  get formControls() {
    return this.questionForm.controls;
  }

  // Put in function to find questions in form to delete them
  // Use questionMap for indexes and dont forget to remove the deleted member/record
  // delete( deletedQuestion: Question){
  //   this.questions.forEach()
  // }

  addQuestion(){
    this.questions.pop();
    this.onSubmit();
    
  }
}
