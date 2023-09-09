import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablecategoriaComponent } from './tablecategoria.component';

describe('TablecategoriaComponent', () => {
  let component: TablecategoriaComponent;
  let fixture: ComponentFixture<TablecategoriaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablecategoriaComponent]
    });
    fixture = TestBed.createComponent(TablecategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
