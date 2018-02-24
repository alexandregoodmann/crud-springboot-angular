import {Risco} from '../../risco/Risco';
import {RiscoService} from '../../risco/risco.service';
import {Cliente} from '../cliente';
import {ClienteService} from '../cliente.service';
import {Component, OnInit, Inject, Output, EventEmitter} from '@angular/core';
import {FormGroup, FormBuilder, ValidationErrors, Validators} from '@angular/forms';

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css'],
  providers: [RiscoService, ClienteService]
})
export class ClienteFormComponent implements OnInit {

  clienteForm: FormGroup;
  riscoList: Risco[];
  @Output() evento = new EventEmitter();

  constructor(
    private riscoService: RiscoService,
    private clienteService: ClienteService,
    private fb: FormBuilder) {
    this.clienteForm = fb.group({
      nome: fb.control('', Validators.required),
      limite: fb.control('', Validators.required),
      risco: fb.control('', Validators.required)
    });
  }

  ngOnInit() {
    this.findRiscos();
  }

  onSubmit(): void {

    const nome = this.clienteForm.get('nome').value;
    const limite = this.clienteForm.get('limite').value;
    const risco = this.clienteForm.get('risco').value;

    this.salvar(nome, limite, risco);
    this.limpar();
    this.evento.emit();
  }

  limpar() {
    this.clienteForm.get('nome').setValue('');
    this.clienteForm.get('limite').setValue('');
    this.clienteForm.get('risco').setValue('');

  }

  findRiscos() {
    this.riscoService.findAll().subscribe(data => {
      this.riscoList = data;
    });
  }

  salvar(nome: string, limite: number, risco: string): void {

    var ris: Risco;
    ris = new Risco();
    ris.risco = risco;

    var cliente: Cliente;
    cliente = new Cliente();
    cliente.nome = nome;
    cliente.limiteCredito = limite;
    cliente.risco = ris;

    this.clienteService.salvar(cliente).subscribe();

  }

}
