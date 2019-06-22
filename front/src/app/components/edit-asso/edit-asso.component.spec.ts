import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAssoComponent } from './edit-asso.component';

describe('EditAssoComponent', () => {
  let component: EditAssoComponent;
  let fixture: ComponentFixture<EditAssoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAssoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAssoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
