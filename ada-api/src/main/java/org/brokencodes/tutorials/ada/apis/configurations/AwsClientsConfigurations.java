package org.brokencodes.tutorials.ada.apis.configurations;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
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
}
