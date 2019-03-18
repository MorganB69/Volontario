import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavInscriComponent } from './nav-inscri.component';

describe('NavInscriComponent', () => {
  let component: NavInscriComponent;
  let fixture: ComponentFixture<NavInscriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavInscriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavInscriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
