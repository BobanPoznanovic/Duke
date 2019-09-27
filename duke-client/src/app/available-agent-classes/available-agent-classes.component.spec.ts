import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailableAgentClassesComponent } from './available-agent-classes.component';

describe('AvailableAgentClassesComponent', () => {
  let component: AvailableAgentClassesComponent;
  let fixture: ComponentFixture<AvailableAgentClassesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvailableAgentClassesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailableAgentClassesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
