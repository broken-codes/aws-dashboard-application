import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardPageComponent } from './pages/dashboard-page/dashboard-page.component';
import { SubnetsComponent } from './pages/vpc/subnets/subnets.component';
import { RouteTablesComponent } from './pages/vpc/route-tables/route-tables.component';
import { PageRdsComponent } from './pages/page-rds/page-rds.component';
import { S3PageComponentComponent } from './pages/s3-page-component/s3-page-component.component';
import { R53PageComponent } from './pages/r53/r53-page/r53-page.component';
import { VpcPeeringComponent } from './pages/vpc/vpc-peering/vpc-peering.component';
import { TransitGatewaysComponent } from './pages/transit-gateways/transit-gateways.component';


const routes: Routes = [
  { path: '', component: DashboardPageComponent },
  { path: 'dashboard', component: DashboardPageComponent },
  { path: 'home', component: DashboardPageComponent },
  { path: 'compute/transit-gateways', component: TransitGatewaysComponent },
  { path: 'ns/vpc/subnets', component: SubnetsComponent },
  { path: 'ns/vpc/route-tables', component: RouteTablesComponent },
  { path: 'rds/information', component: PageRdsComponent },
  { path: 's3/basic-information', component: S3PageComponentComponent },
  { path: 'r53/hosted-zones', component: R53PageComponent },
  { path: 'ns/vpc/vpc-peering', component: VpcPeeringComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
