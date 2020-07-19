package org.brokencodes.tutorials.ada.apis.services.impl.rds;

import com.amazonaws.services.rds.AmazonRDS;
import org.brokencodes.tutorials.ada.apis.beans.rds.RdsBasicInformation;
import org.brokencodes.tutorials.ada.apis.services.apis.rds.IRdsService;
import org.brokencodes.tutorials.ada.apis.services.clients.AwsClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Service
public class RdsService implements IRdsService {

    @Value("${aws-dash.aws.region}")
    private String region;

    @Override
    public Flux<RdsBasicInformation> getRdsBasicInformation(String arn) {
        AmazonRDS rdsClient = AwsClientFactory.rdsClient(arn, region);
        Stream<RdsBasicInformation> rdsBasicInformationStream = rdsClient.describeDBInstances().getDBInstances().stream()
                .map(dbInstance -> RdsBasicInformation.builder()
                        .dbId(dbInstance.getDBInstanceIdentifier())
                        .availabilityZone(dbInstance.getAvailabilityZone())
                        .dbInstanceArn(dbInstance.getDBInstanceArn())
                        .dbStatus(dbInstance.getDBInstanceStatus())
                        .endpoint(
                                String.format("%s:%s:%s",
                                        dbInstance.getEndpoint().getAddress(),
                                        dbInstance.getEndpoint().getPort(),
                                        dbInstance.getEndpoint().getHostedZoneId())
                        )
                        .engine(dbInstance.getEngine())
                        .engineVersion(dbInstance.getEngineVersion())
                        .instanceCreationTime(dbInstance.getInstanceCreateTime().toString())
                        .associatedVpcId(dbInstance.getDBSubnetGroup().getVpcId())
                        .dbSubnetGroupName(dbInstance.getDBSubnetGroup().getDBSubnetGroupName())
                        .build());
        return Flux.fromStream(rdsBasicInformationStream);
    }

}
