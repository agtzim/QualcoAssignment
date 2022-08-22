import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {
  constructor(private httpClient: HttpClient) { }

  getCountries(page: Number, pageSize: Number) {
    const url = `http://localhost:8080/api/countries?page=${page}&pageSize=${pageSize}`
    return this.httpClient.get(url);
  }

  countCountries() {
    const countUrl = 'http://localhost:8080/api/countries/count';
    return this.httpClient.get(countUrl);
  }
}
