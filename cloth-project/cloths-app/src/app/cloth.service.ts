import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Cloth {
  name: string;
  size: string;
  color: string;
}

@Injectable({
  providedIn: 'root'
})
export class ClothService {
  private apiUrl = 'http://localhost:8080/cloth';

  constructor(private http: HttpClient) { }

  getCloths(): Observable<Cloth[]> {
    return this.http.get<Cloth[]>(this.apiUrl);
  }

  addCloth(cloth: Cloth): Observable<Cloth> {
    return this.http.post<Cloth>(this.apiUrl, cloth, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
  }
}
