import { Component } from '@angular/core';
import { LibroService } from 'src/app/Services/libros/libro.service';
import { Libro } from 'src/app/models/libroModel';

@Component({
  selector: 'app-tablelibros',
  templateUrl: './tablelibros.component.html',
  styleUrls: ['./tablelibros.component.css']
})
export class TablelibrosComponent {
  libros: any = [];
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

  constructor(private libroService: LibroService){

  }

  async ngOnInit(){
    this.getlibros();
  }


  getlibros(){
    this.libroService.obtenerlibros().subscribe( res => {
      this.libros = res;
    },
    err => console.error(err)
    )
  }
}
