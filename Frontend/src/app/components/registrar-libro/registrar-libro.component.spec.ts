import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarLibroComponent } from './registrar-libro.component';

describe('RegistrarLibroComponent', () => {
  let component: RegistrarLibroComponent;
  let fixture: ComponentFixture<RegistrarLibroComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistrarLibroComponent]
    });
    fixture = TestBed.createComponent(RegistrarLibroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
