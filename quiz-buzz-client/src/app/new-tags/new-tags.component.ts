import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-new-tags',
  templateUrl: './new-tags.component.html',
  styleUrls: ['./new-tags.component.css']
})
export class NewTagsComponent implements OnInit {

  constructor(private Http: HttpClient, private router: Router) { }

  onSubmit(form: NgForm){
    console.log(form);
    this.Http.post("http://localhost:8080/tags/new",{
      name: form.value.name
    })
    .subscribe({
      next: (data:any)=>{},
      error: (error)=>{
        console.log(error);
      },complete: ()=>{}
    })

  }

  ngOnInit(): void {
  }

}
