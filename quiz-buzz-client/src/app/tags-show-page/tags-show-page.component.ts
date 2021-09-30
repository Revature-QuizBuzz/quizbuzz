import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Tag } from '../models/tags';

@Component({
  selector: 'app-tags-show-page',
  templateUrl: './tags-show-page.component.html',
  styleUrls: ['./tags-show-page.component.css']
})
export class TagsShowPageComponent implements OnInit {

  // create a GET method to get all tags, save all tags to a variable. create a 
  // delete function to delete a specific tag that takes in a tag as an arguement
  // inside the delete method make sure to call the get all tags method so in repopulates 
  // but missing the tag that was deleted

  constructor(private Http: HttpClient, private router: Router) { }


  tags:any = [];


  ngOnInit(): void {
    this.getAllTags();
  }

  getAllTags(){
    this.Http.get<any>('http://localhost:8080/tags').subscribe(
      response => {
        this.tags = response;
      }
    )
  }

  deleteTag(tag: Tag){
    this.Http.delete('http://localhost:8080/tags/' + tag.tagId )
    .subscribe({
        next: data => {
          this.getAllTags();         
        },
        error: error => {
            alert("Sorry, there was a problem with your request.")
        }
        
    });


    // call getalltags method
  }
}
