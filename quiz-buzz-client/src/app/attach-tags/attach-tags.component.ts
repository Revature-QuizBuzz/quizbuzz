import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { Tag } from '../models/tags';
import { CreateQuizService } from '../services/create-quiz.service';

@Component({
  selector: 'app-attach-tags',
  templateUrl: './attach-tags.component.html',
  styleUrls: ['./attach-tags.component.css']
})
export class AttachTagsComponent implements OnInit {
  dropdownList: Tag[] = [];
  selectedItems: Tag[] = [];
  dropdownSettings:IDropdownSettings = {};

  addTagForm:boolean = false;

  constructor(private http:HttpClient, private service:CreateQuizService) { }

  ngOnInit() {
    this.getTags();

    this.dropdownSettings = {
      singleSelection: false,
      idField: 'tagId',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'Unselect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

  getTags() {
    this.service.getTags().subscribe({
      next: (data:any) => {
        if(data !== null) {
          this.dropdownList = data;
        }
      }
    })
  }

  save() {
    console.log(this.selectedItems);
  }
  addTagToggle() {
    this.addTagForm = !this.addTagForm;
  }

  addTag(form:NgForm) {
    this.service.addNewTag(form).subscribe({
      next: (data:any) => {
        if(data !== null) {
          this.dropdownList = data;
          console.log(data);
          console.log(this.dropdownList);
        }
      }
    });
    
    this.getTags();

    this.addTagForm = false;
  }
}

