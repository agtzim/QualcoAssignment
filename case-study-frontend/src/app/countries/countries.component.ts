import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { CountriesService } from './countries.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styles: [`
    div {
        margin: 10vh;
    }
    table {
        width: 100%;
    }
  `]
})
export class CountriesComponent implements OnInit {
  title = 'Countries'
  page = 0;
  pageSize = 5;
  count: any;
  countries: any;
  displayedColumns: String[] = ['countryId', 'name', 'area', 'countryCode2'];

  constructor(private service: CountriesService, private router: Router) { }

  ngOnInit(): void {
    this.service.countCountries()
      .subscribe(response => this.count = response);
    this.service.getCountries(this.page, this.pageSize)
      .subscribe(response => this.countries = response);
  }

  fetchNextPage(event: PageEvent) {
    this.service.getCountries(event.pageIndex, event.pageSize)
      .subscribe(response => this.countries = response);
  }

  showLanguages(row: any) {
    console.log(row);
    this.router.navigate(['/countries', row.countryId]);
  }
}
