import {MessageService} from '../messages/message.service';
import {Cliente} from './cliente';
import {HttpClient} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Headers, Response, RequestOptions, Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {catchError, map, tap} from 'rxjs/operators';
import {of} from 'rxjs/observable/of';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class ClienteService {

  private url = 'http://localhost:8080/crud/cliente/';

  constructor(
    private httpClient: HttpClient,
    private http: Http) {}

  salvar(cliente: Cliente): Observable<Cliente> {

    const uur = this.url + 'salvar';
    var cli: Cliente;

    return this.httpClient.post<Cliente>(uur, cliente, httpOptions).pipe(
      tap((ret: Cliente) => {
        cli = ret;
      }),
      catchError(this.handleError<Cliente>('salvarCliente'))
    );
  }

  findAll(): Observable<Cliente[]> {
    return this.http.get(this.url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}