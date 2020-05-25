import { Component, OnInit } from '@angular/core';
import { Ec2Service } from 'src/app/services/compute/ec2/ec2.service';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-d-instance-state-counter',
  templateUrl: './d-instance-state-counter.component.html',
  styleUrls: ['./d-instance-state-counter.component.css']
})
export class DInstanceStateCounterComponent implements OnInit {

  gradient: boolean = false;
  showLegend: boolean = true;
  showLabels: boolean = true;
  isDoughnut: boolean = false;
  legendPosition: string = 'left';

  colorScheme = {
    domain: ['blue', 'green', 'red', 'orange', 'brown', 'teal']
  };

  displayData = [];

  constructor(private ec2Service: Ec2Service) { }

  ngOnInit(): void {

    // Get ec2 instance state counter
    this.ec2Service.getEc2InstanceStateCount().subscribe(
      data => {
        let ec2InstanceStateCounter = JSON.parse(data)['instanceStateCounter'];
        this.displayData = [
          { "name": "Pending", "value": ec2InstanceStateCounter.countPending },
          { "name": "Running", "value": ec2InstanceStateCounter.countRunning },
          { "name": "Stopped", "value": ec2InstanceStateCounter.countStopped },
          { "name": "Stopping", "value": ec2InstanceStateCounter.countStopping },
          { "name": "Terminated", "value": ec2InstanceStateCounter.countTerminated },
          { "name": "Shutting Down", "value": ec2InstanceStateCounter.countShuttingDown }
        ];
      },
      error => {
        console.error(error);
      });
  }

}
