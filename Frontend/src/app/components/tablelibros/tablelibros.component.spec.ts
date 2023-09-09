import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablelibrosComponent } from './tablelibros.component';

describe('TablelibrosComponent', () => {
  let component: TablelibrosComponent;
  let fixture: ComponentFixture<TablelibrosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablelibrosComponent]
    });
    fixture = TestBed.createComponent(TablelibrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
