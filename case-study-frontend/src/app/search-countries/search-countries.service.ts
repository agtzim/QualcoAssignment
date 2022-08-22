import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchCountriesService {

  constructor(private service: HttpClient) { }

  getRegions() {
    const url = 'http://localhost:8080/api/regions';
    return this.service.get(url);
  }

  countFilteredCountries(region: String, startYear: String, endYear: String) {
    return this.service.get(`http://localhost:8080/api/countries/search/count?region=${region}&startYear=${startYear}&endYear=${endYear}`);
  }

  getFilteredCountries(page: number, pageSize: number, region: string, startYear: String, endYear: String) {
    return this.service.get(`http://localhost:8080/api/countries/search?page=${page}&pageSize=${pageSize}&region=${encodeURI(region)}&startYear=${startYear}&endYear=${endYear}`);
  }
}
