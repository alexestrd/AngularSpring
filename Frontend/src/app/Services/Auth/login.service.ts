import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  

  baseUrl= 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  login(user: any){
    
    return this.http.post(`${this.baseUrl}/login`, user, {responseType: 'text'})
    }

    createHeader(){
      return   {
        headers: new HttpHeaders({
          'Authorization': localStorage.getItem('token')!
        })
      }
    }
}
