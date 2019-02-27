import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-error',
  templateUrl: './modal-error.component.html',
  styleUrls: ['./modal-error.component.css']
})
export class ModalErrorComponent implements OnInit {
  @Input() error;
  @Input() message;

  constructor(public activeModal: NgbActiveModal) {
  }

  ngOnInit() {
  }

  onClose(): void {
    this.activeModal.close('closed');
  }
  onDismiss(reason: String): void {
    this.activeModal.dismiss(reason);
  }

}
