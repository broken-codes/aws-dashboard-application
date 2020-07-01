package org.brokencodes.tutorials.ada.apis.configurations;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClientBuilder;
import com.amazonaws.services.route53.AmazonRoute53;
import com.amazonaws.services.route53.AmazonRoute53ClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsClientsConfigurations {

    @Bean
    public AWSCredentials awsCredentials(
            @Value("${aws-dash.aws.credentials.secret-key}") String secretKey,
            @Value("${aws-dash.aws.credentials.access-key}") String accessKey) {
        return new BasicAWSCredentials(accessKey, secretKey);

    }

    @Bean
    public AmazonEC2 ec2Client(
            AWSCredentials credentials,
            @Value("${aws-dash.aws.region}") String region) {
        return AmazonEC2ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }

    @Bean
    public AmazonRDS rdsClient(
            AWSCredentials credentials,
            @Value("${aws-dash.aws.region}") String region) {
        return AmazonRDSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }

    @Bean
    public AmazonS3 s3Client(
            AWSCredentials credentials,
            @Value("${aws-dash.aws.region}") String region) {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }

    @Bean
    public AmazonRoute53 route53Client(
            AWSCredentials credentials,
            @Value("${aws-dash.aws.region}") String region) {
        return AmazonRoute53ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }
}
