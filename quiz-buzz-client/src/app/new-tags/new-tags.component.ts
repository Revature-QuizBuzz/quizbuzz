import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-new-tags',
  templateUrl: './new-tags.component.html',
  styleUrls: ['./new-tags.component.css']
})
export class NewTagsComponent implements OnInit {


  constructor(private Http: HttpClient, private router: Router) { }

  tagName='';

  onSubmit(form: NgForm){
    this.Http.post("http://localhost:8080/tags/new",{
      name: form.value.name
    })
    .subscribe({
      next: (data:any)=>{ 
        console.log(data);
      },
      error: (data)=>{
        if(data.status === 500){
          alert("We're sorry, something went wrong!" + "\nThis tag may already exist.")
        }

      },complete: ()=>{}
    })
    this.handleClear();
  }

  handleClear(){
    this.tagName = '';
  }

  ngOnInit(): void {
  }

}
