import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Output, EventEmitter} from '@angular/core';
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

  savedItems: Tag[] = [];

  @Output() tags = new EventEmitter<Tag[]>();

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
    this.savedItems = this.selectedItems;
    this.tags.emit(this.savedItems);
  }

  close() {
    this.selectedItems = this.savedItems;
  }

  addTagToggle() {
    this.addTagForm = !this.addTagForm;
  }

  updateTags() {
    this.getTags();
    this.addTagToggle();
  }

}

