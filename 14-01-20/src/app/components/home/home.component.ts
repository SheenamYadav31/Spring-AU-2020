import { Component, OnInit, OnDestroy  } from '@angular/core';
import { ReactiveForms, FormGroup, Validators, FormControl } from '@angular/forms';
import { DataService } from 'src/app/providers/data.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit ,OnDestroy {

  constructor(public dataser: DataService) {
   }
  person = {
    id: "",
    name: "",
    age: "",
    address: {
      hno: "",
      city: "",
      pincode: ""
    },
    phone: "",
    email: ""
  };
  content = new FormGroup({
    id: new FormControl('',[Validators.required]),
    firstname: new FormControl('Sheenam',[Validators.required, Validators.minLength(3)]),
    age: new FormControl(),
    phone: new FormControl('',[Validators.minLength(10),Validators.maxLength(10)]),
    email: new FormControl('',Validators.email),
    address: new FormGroup({
      hno: new FormControl(),
      city: new FormControl(),
      pincode: new FormControl()
    })
  }); 
  submitfunction(){
    console.log(this.content.value.firstname);
    this.person.id = this.content.value.id;
    this.person.name = this.content.value.firstname;
    this.person.age = this.content.value.age;
    this.person.address.hno = this.content.value.address.hno;
    this.person.address.city = this.content.value.address.city;
    this.person.address.pincode= this.content.value.address.pincode;
    this.person.phone = this.content.value.phone;
    this.person.email = this.content.value.email;

    this.dataser.savemydata(this.person);
  }
  ngOnInit() {
  }

  ngOnDestroy(){
  	console.log("home destroy")

  }

}
