import { Component, inject } from '@angular/core';
import { RegistrerService } from 'src/app/Services/Auth/registrer.service';
import { FormsModule, FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user!: FormGroup;
  pass: boolean = false;
  usuario: User = {
    id: '',
    nombre: '',
    apellido: '',
    email: '',
    password: '',
    telefono: '',
    permisos: 0
  }
  router = inject(Router);
  constructor(private registerService: RegistrerService, private fb : FormBuilder){
    this.user = this.fb.group ({
      id:[''],
      nombre: ['',Validators.required],
      apellido: ['', Validators.required],
      email: ['',[Validators.required, Validators.email]],
      password: ['', Validators.required],
      passwordconfirm: ['', [Validators.required,Validators.pattern(/^(?=.*\d)([A-Za-z\d$@$!%*?&]|[^ ]){8,15}$/)]],
      telefono: ['', [Validators.required, Validators.pattern(/^(?=.*\d)([0-9]){10}$/)]]
    }) 
    this.confiramarContraseña();
  }
  

  registrar(){
    console.log(this.user.value)
    this.usuario = {
      id: '',
    nombre: this.user.value['nombre'],
    apellido: this.user.value['apellido'],
    email: this.user.value['email'],
    password: this.user.value['password'],
    telefono: this.user.value['telefono'],
    permisos: 1
    }
    
    this.registerService.registrar(this.usuario).subscribe(
      res =>{
        console.log(res);
        alert("registrado con exito");
        this.router.navigate(['/home']);
      },
      err => console.error(err)
    )
  }
   confiramarContraseña(){
    if(this.user.value['password'] == this.user.value['passwordconfirm']){
      this.pass = true;
    }else{
      this.pass = false;
    }
  }

  

}
