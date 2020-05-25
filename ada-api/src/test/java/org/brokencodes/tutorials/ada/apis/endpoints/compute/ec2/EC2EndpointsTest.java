package org.brokencodes.tutorials.ada.apis.endpoints.compute.ec2;

import org.brokencodes.tutorials.ada.apis.beans.compute.ec2.InstanceStateCounter;
import org.brokencodes.tutorials.ada.apis.endpoints.compute.ec2.responses.Ec2InstanceStateCounterResponse;
import org.brokencodes.tutorials.ada.apis.services.impl.compute.EC2Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class EC2EndpointsTest {

    @InjectMocks
    private EC2Endpoints sut;

    @Mock
    private EC2Service ec2Service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getInstancesStateCount() {
        Mono<InstanceStateCounter> mockedInstanceStateCounter = Mono.just(InstanceStateCounter.builder()
                .countPending(10)
                .countRunning(15)
                .countTerminated(3)
                .countTotal(28)
                .build());
        when(ec2Service.getInstanceStateCounter()).thenReturn(mockedInstanceStateCounter);

        Mono<Ec2InstanceStateCounterResponse> instancesStateCount = sut.getInstancesStateCount();

        assertThat(instancesStateCount).isNotNull();
        Ec2InstanceStateCounterResponse responseObject = instancesStateCount.block();
        assertThat(responseObject).isNotNull();
        InstanceStateCounter counter = responseObject.getInstanceStateCounter();
        assertThat(counter).isNotNull();
        assertThat(counter.getCountTotal()).isEqualTo(28);
        assertThat(counter.getCountPending()).isEqualTo(10);
        assertThat(counter.getCountRunning()).isEqualTo(15);
        assertThat(counter.getCountTerminated()).isEqualTo(3);
    }

}