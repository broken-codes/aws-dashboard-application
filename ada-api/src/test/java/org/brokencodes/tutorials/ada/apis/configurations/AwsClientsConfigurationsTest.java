package org.brokencodes.tutorials.ada.apis.configurations;

import com.amazonaws.auth.AWSCredentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Profile("run-integration-tests")
class AwsClientsConfigurationsTest {

//    @InjectMocks
//    private AwsClientsConfigurations sut;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void awsCredentials() {
//        AWSCredentials awsCredentials = sut.awsCredentials("1", "1");
//        assertThat(awsCredentials).isNotNull();
//    }
//
//    @Test
//    void ec2Client() {
//        AWSCredentials mockedAwsCredentials = mock(AWSCredentials.class);
//    }

}