import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeEcole } from './ListeEcole.component';

describe('ListeEcole', () => {
  let component: ListeEcole;
  let fixture: ComponentFixture<ListeEcole>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeEcole ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeEcole);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
