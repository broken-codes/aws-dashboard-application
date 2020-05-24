import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { DInstanceStateCounterComponent } from './components/compute/ec2/d-instance-state-counter/d-instance-state-counter.component';
import { IconsProviderModuleModule } from './modules/icons-provider-module/icons-provider-module.module';
import { NgZorroModuleModule } from './modules/ng-zorro-module/ng-zorro-module.module';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    DInstanceStateCounterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    IconsProviderModuleModule,
    NgZorroModuleModule,
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
