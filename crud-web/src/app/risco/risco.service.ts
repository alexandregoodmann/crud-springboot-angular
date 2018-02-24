import {Risco} from './Risco';
import {Injectable} from '@angular/core';
import {Response, Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RiscoService {

  private url = 'http://localhost:8080/crud/risco';

  constructor(private http: Http) {}

  findAll(): Observable<Risco[]> {
    return this.http.get(this.url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

}
