import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-delete-tag',
  templateUrl: './delete-tag.component.html',
  styleUrls: ['./delete-tag.component.css']
})
export class DeleteTagComponent implements OnInit {

  constructor(private Http: HttpClient, private router: Router) { }
  tagName='';
  @Output() removeTag = new EventEmitter();

  onSubmit(form: NgForm){
    this.Http.delete("http://localhost:8080/tags/" + form.value.id, {name: form.value.name})
    .subscribe({
      next: (data:any)=>{
        console.log(data);
      },
      error: (data)=>{
        if(data.status === 500){
          alert("We're sorry, something went wrong!" + "\nThis tag was unable to be removed.")
        }

      },complete: ()=>{}
    })
    this.handleClear();
  }
  
  handleClear(){
    this.tagName = '';
    this.removeTag.emit();
    console.log("here");
    }

  ngOnInit(): void {
  }

}
