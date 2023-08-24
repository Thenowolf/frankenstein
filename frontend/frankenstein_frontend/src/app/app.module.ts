import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { Constants } from './config/constants';
import { UserComponent } from './user/user.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTableModule} from '@angular/material/table';
import { SignupComponent } from './component/signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NoopAnimationsModule,
    MatSlideToggleModule,
    MatToolbarModule, MatButtonModule, MatIconModule,
    MatTableModule,
    FormsModule, ReactiveFormsModule
  ],
  providers: [{provide: "CONF", useValue: Constants}],
  bootstrap: [AppComponent]
})
export class AppModule { }
