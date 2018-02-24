import {Cliente} from '../cliente';
import {ClienteService} from '../cliente.service';
import {Component, OnInit, Provider} from '@angular/core';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css'],
  providers: [ClienteService]
})
export class ClienteListComponent implements OnInit {

  cliente: Cliente;
  clientes: Cliente[];

  constructor(private clienteService: ClienteService) {}

  ngOnInit(): void {
    this.listar();
  }
  
  listar() {
    this.clienteService.findAll().subscribe(data => {
      this.clientes = data;
    });
  }
}
