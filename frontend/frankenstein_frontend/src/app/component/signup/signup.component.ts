import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SignupService } from 'src/app/service/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  signupForm!: FormGroup;

  constructor(private signupService:SignupService, private formBuilder: FormBuilder){}

  ngOnInit() {
    this.signupForm = this.formBuilder.group({
      username: ['default value', [/*Validators*/]],
      password: ['default value', [/*Validators*/]]
    })
  }

  signup(){
    this.signupService.createUser(this.signupForm.value.username, this.signupForm.value.password)
  }
}
