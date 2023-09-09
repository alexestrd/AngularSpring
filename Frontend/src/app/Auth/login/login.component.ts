import { Token } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormsModule, FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/Services/Auth/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userLogin: any = {
    email: "",
    password: ""
}
  login!: FormGroup;
  constructor(private loginService : LoginService, private router : Router,private fb : FormBuilder){
    this.login = this.fb.group ({
      email: ['',[Validators.required, Validators.email]],
      password: ['', Validators.required]
    }) 
  }


  onSubmit() {
    this.userLogin = {
      email: this.login.value['email'],
      password: this.login.value['password']
    }
    this.loginService.login(this.userLogin).subscribe(
      res =>{
        console.log(res)
        localStorage.setItem("token", res);
        this.router.navigate(['/home']);
      },
      err => console.error(err)
    )
   
  }
}
