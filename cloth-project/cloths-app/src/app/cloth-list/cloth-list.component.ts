import { Component, OnInit } from '@angular/core';
import { Cloth, ClothService } from '../cloth.service';

@Component({
  selector: 'app-cloth-list',
  templateUrl: './cloth-list.component.html',
  styleUrls: ['./cloth-list.component.css']
})
export class ClothListComponent implements OnInit {
  cloths: Cloth[] = [];
  newCloth: Cloth = { name: '', size: '', color: '' };

  constructor(private clothService: ClothService) { }

  ngOnInit(): void {
    this.loadCloths();
  }

  loadCloths(): void {
    this.clothService.getCloths().subscribe(
      data => this.cloths = data,
      error => console.error(error)
    );
  }

  addCloth(): void {
    if (this.newCloth.name && this.newCloth.size && this.newCloth.color) {
      this.clothService.addCloth(this.newCloth).subscribe(
        () => {
          this.newCloth = { name: '', size: '', color: '' };
          this.loadCloths();
        },
        error => console.error(error)
      );
    }
  }
}
