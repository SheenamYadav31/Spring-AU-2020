import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/providers/data.service';


@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  constructor(public dataser: DataService) { }
  userdetails: [];
  ngOnInit() {
  	this.userdetails = this.dataser.getmydata();
  }

}
