import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Pelicula} from '../models/pelicula.model';

@Injectable({
  providedIn: 'root'
})
export class PeliculasService {
  private apiURL = 'http://localhost:8080/peliculas'

  constructor(private http: HttpClient) { }

  getAll(): Observable<Pelicula[]> {
    return this.http.get<Pelicula[]>(this.apiURL)
  }

  getById(id: number): Observable<Pelicula> {
    return  this.http.get<Pelicula>(`${this.apiURL}/id/${id}`)
  }

  search() {

  }

  add() {

  }

  update() {

  }

  delete() {

  }
}
