import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.css']
})
export class NotFoundComponent implements OnInit, OnDestroy {

  constructor() {
  	console.log("app-not-found costrocute")

   }

  ngOnInit() {
  	console.log("app-not-found inint")
  }

  ngOnDestroy(){
  	console.log("app-not-found destroy")

  }

}
