import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-inscri',
  templateUrl: './nav-inscri.component.html',
  styleUrls: ['./nav-inscri.component.css']
})
export class NavInscriComponent implements OnInit {
  benevole = false;
  association = false;
  constructor() { }

  ngOnInit() {
  }

  beneSelected() {
    this.benevole = true;
    this.association = false;
  }
  assoSelected() {
    this.benevole = false;
    this.association = true;
  }

}
