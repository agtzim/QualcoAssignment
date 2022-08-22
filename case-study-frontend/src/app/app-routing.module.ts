import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CountriesWithStatsComponent } from './countries-with-stats/countries-with-stats.component';
import { CountriesComponent } from './countries/countries.component';
import { CountryLanguagesComponent } from './country-languages/country-languages.component';
import { HomeComponent } from './home/home.component';
import { SearchCountriesComponent } from './search-countries/search-countries.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'countries', component: CountriesComponent},
  {path: 'countries/search', component: SearchCountriesComponent},
  {path: 'countries/stats', component: CountriesWithStatsComponent},
  {path: 'countries/:countryId', component: CountryLanguagesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
