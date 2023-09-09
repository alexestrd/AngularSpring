import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Libro } from 'src/app/models/libroModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibroService {

  baseUrl= 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  register(datos: FormData) {
    const httOptions = {
      headers : new HttpHeaders({
        'Autorization': localStorage.getItem('token')!
      })
    }

    return this.http.post(`${this.baseUrl}/libros`, datos )
  }

  obtenerlibros(){
    const httOptions = {
      headers : new HttpHeaders({
        'Autorization': localStorage.getItem('token')!
      })
    }
    return this.http.get(`${this.baseUrl}/libros`, httOptions)
  }
}
