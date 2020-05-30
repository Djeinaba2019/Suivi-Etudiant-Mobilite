import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EcolePartenaireComponent } from './ecole-partenaire.component';

describe('EcolePartenaireComponent', () => {
  let component: EcolePartenaireComponent;
  let fixture: ComponentFixture<EcolePartenaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EcolePartenaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EcolePartenaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
