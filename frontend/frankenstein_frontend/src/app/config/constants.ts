import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Config } from '../common/config';

@Injectable({
  providedIn: 'root'
})
export class Constants implements Config {
  public baseUrl(): string {
    return environment.baseUrl;
  }
}
