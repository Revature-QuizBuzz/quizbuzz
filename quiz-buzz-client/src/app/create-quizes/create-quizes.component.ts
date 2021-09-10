import { Component, OnInit } from '@angular/core';
import { Quiz } from '../models/quizzes';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


const baseUrl = 'http://localhost:8080/quizzes/createQuiz';

@Component({
  selector: 'app-create-quizes',
  templateUrl: './create-quizes.component.html',
  styleUrls: ['./create-quizes.component.css']
})

export class CreateQuizesComponent implements OnInit {
  quiz!: Quiz;
  submitted = false;
  createQuiz!: FormGroup;
  // userId: number | null = <number><unknown>localStorage.getItem('userId');
  storageValue: string | null = localStorage.getItem('userId');
  userId = JSON.parse(localStorage.getItem('userId')) as number;




  constructor(private httpClient: HttpClient, private http: HttpClient, private fb: FormBuilder) {


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

  create(quiz: Quiz): Observable<any> {
    return this.http.post(baseUrl, quiz);
  }

  onSubmit({ value, valid }: { value: Quiz, valid: boolean }): void {
    console.log(value, valid);
    let amount: number = 0; // We define 0 as default amount
    if (this.storageValue !== null) {
      amount = parseInt(this.storageValue, 10);
    }
    this.quiz.userId = amount;
    this.quiz = value;

    // if (confirm("You have succesfully added a new quiz"))
    //   this.create(userId)
    //     .subscribe(
    //       response => {
    //         console.log(response);
    //         this.submitted = true;
    //       },
    //       error => {
    //         console.log(error);
    //       });
  }


  addQuestion() {

  }

  // incase we want to pass date more neatly
  // formatDate(date:any) {
  //   let d = new Date(date);
  //   return d.getMonth() + "/" + d.getDate() + "/" + d.getFullYear();
  // }

}
