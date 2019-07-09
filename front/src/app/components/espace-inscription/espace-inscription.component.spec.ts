import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EspaceInscriptionComponent } from './espace-inscription.component';

describe('EspaceInscriptionComponent', () => {
  let component: EspaceInscriptionComponent;
  let fixture: ComponentFixture<EspaceInscriptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EspaceInscriptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EspaceInscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
