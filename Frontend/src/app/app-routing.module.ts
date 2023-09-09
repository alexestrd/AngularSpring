import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Auth/login/login.component';
import { RegisterComponent } from './Auth/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { loginGuard } from './guards/login.guard';
import { RegistrarLibroComponent } from './components/registrar-libro/registrar-libro.component';
import { LibrosComponent } from './components/libros/libros.component';
import { TablelibrosComponent } from './components/tablelibros/tablelibros.component';
import { BuscarlibroComponent } from './components/buscarlibro/buscarlibro.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'registro', component: RegisterComponent},
  {path: 'home', component: HomeComponent, canActivate: [loginGuard]},
  {path: 'libros', component: LibrosComponent,
  children: [
    {path: '', component: TablelibrosComponent},
    {path: 'registro', component: RegistrarLibroComponent},
    {path: 'busqueda', component: BuscarlibroComponent}
  ]  
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
