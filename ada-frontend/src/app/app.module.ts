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

import { NgxChartsModule } from '@swimlane/ngx-charts';

import { HomePageComponent } from './pages/home-page/home-page.component';
import { DInstanceStateCounterComponent } from './components/compute/ec2/d-instance-state-counter/d-instance-state-counter.component';
import { IconsProviderModuleModule } from './modules/icons-provider-module/icons-provider-module.module';
import { NgZorroModuleModule } from './modules/ng-zorro-module/ng-zorro-module.module';
import { DashboardPageComponent } from './pages/dashboard-page/dashboard-page.component';
import { DVpcInfoComponent } from './components/ns/vpc/d-vpc-info/d-vpc-info.component';
import { SubnetsComponent } from './pages/vpc/subnets/subnets.component';
import { CSubnetsComponent } from './components/ns/vpc/c-subnets/c-subnets.component';
import { RouteTablesComponent } from './pages/vpc/route-tables/route-tables.component';
import { CRouteTablesComponent } from './components/ns/vpc/c-route-tables/c-route-tables.component';
import { PageRdsComponent } from './pages/page-rds/page-rds.component';
import { CRdsInformationComponent } from './components/rds/c-rds-information/c-rds-information.component';
import { S3PageComponentComponent } from './pages/s3-page-component/s3-page-component.component';
import { CS3BasicInformationComponent } from './components/c-s3-basic-information/c-s3-basic-information.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    DInstanceStateCounterComponent,
    DashboardPageComponent,
    DVpcInfoComponent,
    SubnetsComponent,
    CSubnetsComponent,
    RouteTablesComponent,
    CRouteTablesComponent,
    PageRdsComponent,
    CRdsInformationComponent,
    S3PageComponentComponent,
    CS3BasicInformationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    IconsProviderModuleModule,
    NgZorroModuleModule,
    NgxChartsModule,
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent]
})
export class AppModule { }
