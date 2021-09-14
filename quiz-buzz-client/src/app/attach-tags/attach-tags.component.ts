import { Component, OnInit } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';

@Component({
  selector: 'app-attach-tags',
  templateUrl: './attach-tags.component.html',
  styleUrls: ['./attach-tags.component.css']
})
export class AttachTagsComponent implements OnInit {
  dropdownList: Array<any> = [];
  selectedItems: Array<any> = [];
  dropdownSettings:IDropdownSettings = {};

  constructor() { }

  ngOnInit() {
    this.dropdownList = [
      { item_id: 1, 
        item_text: 'Java' },
      { item_id: 2, 
        item_text: 'SQL' },
      { item_id: 3, 
        item_text: 'Spring' },
      { item_id: 4, 
        item_text: 'Docker' },
      { item_id: 5, 
        item_text: 'Hibernate' }
    ];
    this.selectedItems = [
      { item_id: 3, 
        item_text: 'Spring' },
      { item_id: 4, 
        item_text: 'Docker' }
    ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'Unselect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }
  onItemSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
}

