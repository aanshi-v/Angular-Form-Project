import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetRegComponent } from './get-reg.component';

describe('GetRegComponent', () => {
  let component: GetRegComponent;
  let fixture: ComponentFixture<GetRegComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetRegComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
