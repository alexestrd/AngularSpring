import { Component } from '@angular/core';
import { LibroService } from 'src/app/Services/libros/libro.service';
import { Libro } from 'src/app/models/libroModel';

@Component({
  selector: 'app-registrar-libro',
  templateUrl: './registrar-libro.component.html',
  styleUrls: ['./registrar-libro.component.css']
})
export class RegistrarLibroComponent {

   libro : Libro = {
    id: "",
    nombre: "",
    resumen: "",
    autor: "",
    editorial: "",
    imagen: "",
    archivo:"",
    id_categoria: "1"

  };
  imagenData :any = [];
  archivoData :any = [];

  constructor(private libroService : LibroService){

  }

  imagen(event: any){
    const file  = event.target.files[0];
    
    if(file){
      this.imagenData.push(file);
    }
  }


  archivo(event: any){
    const file = event.target.files[0];

    if(file){
      this.archivoData.push(file);
      }
  }

  enviar():any{
    try {
      const datos = new FormData();
      this.imagenData.forEach((data: any) => {
        datos.append('imagen', data);
        console.log(data);
      });
      this.archivoData.forEach((data : any) => {
        datos.append('archivo', data);
      });
      let libroData = {nombre: this.libro.nombre, resumen: this.libro.resumen, autor: this.libro.autor, editorial: this.libro.editorial,imagen: this.libro.imagen, archivo: this.libro.archivo,id_cetgoria: this.libro.id_categoria}
      datos.append("libro", JSON.stringify(libroData));
      this.libroService.register(datos).subscribe(
        res =>{
          console.log(res)
        },
        err => console.error(err)
      )
    } catch (e) {
      
    }
  }
  }

