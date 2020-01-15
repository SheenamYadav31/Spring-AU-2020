import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { DetailsComponent } from './components/details/details.component';
import { NotFoundComponent } from './components/not-found/not-found.component';



const routes: Routes = [
	{path: "home", component:HomeComponent},
	{path: "view", component:DetailsComponent},
	{path: "about", component: AboutComponent},
	{path: "", redirectTo:"/about",pathMatch:"full"},
	{path: "**", component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
