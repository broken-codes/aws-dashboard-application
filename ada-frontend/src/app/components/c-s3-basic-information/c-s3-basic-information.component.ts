import { Component, OnInit } from '@angular/core';
import { S3ServiceService } from 'src/app/services/s3/s3-service.service';

@Component({
  selector: 'app-c-s3-basic-information',
  templateUrl: './c-s3-basic-information.component.html',
  styleUrls: ['./c-s3-basic-information.component.css']
})
export class CS3BasicInformationComponent implements OnInit {

  listOfS3BasicInformation = [];

  constructor(private s3Service: S3ServiceService) { }

  ngOnInit(): void {
    this.s3Service.getBasicS3Information()
      .subscribe(
        data => {
          let obtainedData = JSON.parse(data);
          this.listOfS3BasicInformation.push(
            new S3BasicInformation(this.listOfS3BasicInformation.length + 1, obtainedData)
          )
        },
        error => {
          console.log("Error processing")
        }
      );
  }

}

export class S3BasicInformation {

  key = 0;
  name = "";
  createdOn = "";
  owner = "";

  constructor(key: number, data: any) {
    this.key = data.key;
    this.name = data.name;
    this.createdOn = data.createdOn;
    this.owner = data.owner;
  }

}
