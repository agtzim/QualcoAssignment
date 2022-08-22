import { Component, OnInit } from '@angular/core';
import { CountriesWithStatsService } from './countries-with-stats.service';

@Component({
  selector: 'app-countries-with-stats',
  templateUrl: './countries-with-stats.component.html',
  styles: []
})
export class CountriesWithStatsComponent implements OnInit {
  dataSource: any;
  displayedColumns = ['name', 'countryCode3', 'year', 'population', 'gdp'];

  constructor(private service: CountriesWithStatsService) { }

  ngOnInit(): void {
    this.service.getCountriesWithStats().subscribe(response => this.dataSource = response);
  }
}
