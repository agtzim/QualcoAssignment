import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LanguagesService } from './languages.service';

@Component({
  selector: 'app-country-languages',
  templateUrl: './country-languages.component.html',
  styles: []
})
export class CountryLanguagesComponent implements OnInit {
  languages: any

  constructor(private route: ActivatedRoute, private service: LanguagesService) { }

  ngOnInit(): void {
    let countryId = this.route.snapshot.paramMap.get('countryId');
    if (countryId) {
      this.service.getCountries(countryId).subscribe(result => this.languages = result);
    }
  }
}
