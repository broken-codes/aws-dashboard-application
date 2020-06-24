import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardPageComponent } from './pages/dashboard-page/dashboard-page.component';
import { SubnetsComponent } from './pages/vpc/subnets/subnets.component';
import { RouteTablesComponent } from './pages/vpc/route-tables/route-tables.component';
import { PageRdsComponent } from './pages/page-rds/page-rds.component';
import { S3PageComponentComponent } from './pages/s3-page-component/s3-page-component.component';


const routes: Routes = [
  { path: '', component: DashboardPageComponent },
  { path: 'dashboard', component: DashboardPageComponent },
  { path: 'home', component: DashboardPageComponent },
  { path: 'ns/vpc/subnets', component: SubnetsComponent },
  { path: 'ns/vpc/route-tables', component: RouteTablesComponent },
  { path: 'rds/information', component: PageRdsComponent },
  { path: 's3/basic-information', component: S3PageComponentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
