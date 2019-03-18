import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionBenevoleComponent } from './inscription-benevole.component';

describe('InscriptionBenevoleComponent', () => {
  let component: InscriptionBenevoleComponent;
  let fixture: ComponentFixture<InscriptionBenevoleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscriptionBenevoleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscriptionBenevoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
