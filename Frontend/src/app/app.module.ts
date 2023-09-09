import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Auth/login/login.component';
import { RegisterComponent } from './Auth/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { RegistrarLibroComponent } from './components/registrar-libro/registrar-libro.component';
import { CategoriasComponent } from './components/categorias/categorias.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LibrosComponent } from './components/libros/libros.component';
import { TablelibrosComponent } from './components/tablelibros/tablelibros.component';
import { BuscarlibroComponent } from './components/buscarlibro/buscarlibro.component';
import { CategoriaComponent } from './components/categoria/categoria/categoria.component';
import { TablecategoriaComponent } from './components/categoria/tablecategoria/tablecategoria.component';
import { AddcategoriaComponent } from './components/categoria/addcategoria/addcategoria.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    RegistrarLibroComponent,
    NavbarComponent,
    LibrosComponent,
    TablelibrosComponent,
    BuscarlibroComponent,
    CategoriaComponent,
    TablecategoriaComponent,
    AddcategoriaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
