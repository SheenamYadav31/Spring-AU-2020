import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() { }

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
  details = [{id: "01", name:"BlueMan", age: "90", address:{hno:"123", city:"RandomCity", pincode:"456124"} ,phone:"1234567890", email:"dhf@gmail.com" }];

  savemydata(data){
  	this.person.id = data.id;
  	this.person.name = data.name;
  	this.person.age = data.age;
  	this.person.address.hno = data.address.hno;
    this.person.address.city = data.address.city;
    this.person.address.pincode = data.address.pincode;
  	this.person.phone = data.phone;
  	this.person.email = data.email;

  	this.details.push(this.person);
  	console.log(this.person);
  }

  getmydata(){
  	return this.details;
  }
}
