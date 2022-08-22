import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LanguagesService {

  constructor(private httpClient: HttpClient) { }

  getCountries(countryId: String) {
    const url = `http://localhost:8080/api/countries/languages/${countryId}`;
    return this.httpClient.get(url);
  }
}
