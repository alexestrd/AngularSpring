import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrerService {

  baseUrl= 'http://localhost:8080/api';

  constructor(private http: HttpClient) { 
  }

  registrar(user: User){
    return this.http.post<any>(`${this.baseUrl}/register`, user)
    
  }
}
