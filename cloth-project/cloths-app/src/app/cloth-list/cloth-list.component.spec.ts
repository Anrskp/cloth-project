import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClothListComponent } from './cloth-list.component';

describe('ClothListComponent', () => {
  let component: ClothListComponent;
  let fixture: ComponentFixture<ClothListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClothListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClothListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
