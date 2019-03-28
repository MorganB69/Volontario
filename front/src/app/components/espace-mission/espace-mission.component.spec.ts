import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EspaceMissionComponent } from './espace-mission.component';

describe('EspaceMissionComponent', () => {
  let component: EspaceMissionComponent;
  let fixture: ComponentFixture<EspaceMissionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EspaceMissionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EspaceMissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
