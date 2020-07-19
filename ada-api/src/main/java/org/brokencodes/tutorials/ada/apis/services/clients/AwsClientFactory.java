package org.brokencodes.tutorials.ada.apis.services.clients;

import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClientBuilder;
import com.amazonaws.services.route53.AmazonRoute53;
import com.amazonaws.services.route53.AmazonRoute53ClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AwsClientFactory {

    public static AmazonEC2 ec2Client(
            String arn,
            String region) {
        return AmazonEC2ClientBuilder.standard()
                .withCredentials(awsCredentials(arn))
                .withRegion(region)
                .build();
    }

    public static AmazonRDS rdsClient(
            String arn,
            String region) {
        return AmazonRDSClientBuilder.standard()
                .withCredentials(awsCredentials(arn))
                .withRegion(region)
                .build();
    }

    public static AmazonS3 s3Client(
            String arn,
            String region) {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(awsCredentials(arn))
                .withRegion(region)
                .build();
    }

    public static AmazonRoute53 route53Client(
            String arn,
            String region) {
        return AmazonRoute53ClientBuilder.standard()
                .withCredentials(awsCredentials(arn))
                .withRegion(region)
                .build();
    }

    private static STSAssumeRoleSessionCredentialsProvider awsCredentials(
            String arnRole) {
        return new STSAssumeRoleSessionCredentialsProvider
                .Builder(arnRole, "aws@dash")
                .build();
    }

}
