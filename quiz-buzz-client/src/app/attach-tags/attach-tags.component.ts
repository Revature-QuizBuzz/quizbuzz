import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { Tag } from '../models/tags';

@Component({
  selector: 'app-attach-tags',
  templateUrl: './attach-tags.component.html',
  styleUrls: ['./attach-tags.component.css']
})
export class AttachTagsComponent implements OnInit {
  dropdownList: Tag[] = [];
  selectedItems: Tag[] = [];
  dropdownSettings:IDropdownSettings = {};

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.get('http://localhost:8080/tags').subscribe({
      next: (data:any) => {
        if(data !== null) {
          this.dropdownList = data;
          console.log(data);
          console.log(this.dropdownList);
        }
      }
    })
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'Unselect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }
  save() {
    console.log(this.selectedItems);
  }
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
}

