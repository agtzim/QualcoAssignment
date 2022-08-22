import { Component, OnInit } from '@angular/core';
import { DateSelectionModelChange } from '@angular/material/datepicker';
import { PageEvent } from '@angular/material/paginator';
import { SearchCountriesService } from './search-countries.service';

@Component({
  selector: 'app-search-countries',
  templateUrl: './search-countries.component.html',
  styles: ['table {width: 100%; margin-top: 8px; margin-bottom: 8px}']
})
export class SearchCountriesComponent implements OnInit {
  displayedColumns = ['continent', 'region', 'country', 'year', 'population', 'gdp'];
  dataSource: any;
  regions: any;
  selectedRegion: any;

  count: any;
  page: number;
  pageSize: number;

  startDate: any;
  endDate: any;

  constructor(private service: SearchCountriesService) {
    this.page = 0;
    this.pageSize = 8;
  }

  ngOnInit(): void {
    this.service.getRegions().subscribe(res => this.regions = res);

    this.service.countFilteredCountries('', '', '')
      .subscribe(res => this.count = res);

    this.service.getFilteredCountries(this.page, this.pageSize, '', '', '')
      .subscribe(res => this.dataSource = res);
  }

  fetchNextPage(event: PageEvent) {
    this.page = event.pageIndex;
    this.service.getFilteredCountries(event.pageIndex, this.pageSize, this.selectedRegion.name, this.startDate.getFullYear().toString(), this.endDate.getFullYear().toString())
      .subscribe(res => this.dataSource = res);
  }

  filterData() {
    // Update count and datasource
    this.service.countFilteredCountries(this.selectedRegion.name, this.startDate.getFullYear().toString(), this.endDate.getFullYear().toString())
      .subscribe(res => this.count = res);
    
    this.service.getFilteredCountries(this.page, this.pageSize, this.selectedRegion.name, this.startDate.getFullYear().toString(), this.endDate.getFullYear().toString())
      .subscribe(res => this.dataSource = res);
  }
}
