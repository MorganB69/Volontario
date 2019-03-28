import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EspaceAssoComponent } from './espace-asso.component';

describe('EspaceAssoComponent', () => {
  let component: EspaceAssoComponent;
  let fixture: ComponentFixture<EspaceAssoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EspaceAssoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EspaceAssoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
