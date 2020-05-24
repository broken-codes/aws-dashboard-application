package org.brokencodes.tutorials.ada.apis.services.impl.compute;

import com.amazonaws.services.ec2.AmazonEC2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class EC2ServiceTest {

    @InjectMocks
    private EC2Service sut;

    @Mock
    private AmazonEC2 ec2Client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getInstanceStateCounter() {

    }

}