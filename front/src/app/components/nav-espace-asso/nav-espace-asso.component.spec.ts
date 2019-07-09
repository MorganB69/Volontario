import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavEspaceAssoComponent } from './nav-espace-asso.component';

describe('NavEspaceAssoComponent', () => {
  let component: NavEspaceAssoComponent;
  let fixture: ComponentFixture<NavEspaceAssoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavEspaceAssoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavEspaceAssoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
