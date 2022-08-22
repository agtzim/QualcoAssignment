import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CountriesWithStatsService {

  constructor(private httpClient: HttpClient) { }

  getCountriesWithStats() {
    const url = "http://localhost:8080/api/countries/stats";
    return this.httpClient.get(url);
  }
}
