import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewTagsComponent } from './new-tags/new-tags.component';

export const routes: Routes = [
  {path:" ", component: NewTagsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
