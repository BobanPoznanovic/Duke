import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StopAgentComponent } from './stop-agent.component';

describe('StopAgentComponent', () => {
  let component: StopAgentComponent;
  let fixture: ComponentFixture<StopAgentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StopAgentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StopAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
