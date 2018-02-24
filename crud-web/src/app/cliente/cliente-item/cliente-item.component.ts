import {Cliente} from '../cliente';
import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-cliente-item',
  templateUrl: './cliente-item.component.html',
  styleUrls: ['./cliente-item.component.css']
})
export class ClienteItemComponent {

  @Input() cliente;

  constructor() {}

}
