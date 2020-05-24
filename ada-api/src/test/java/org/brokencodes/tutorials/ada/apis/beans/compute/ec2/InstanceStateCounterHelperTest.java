package org.brokencodes.tutorials.ada.apis.beans.compute.ec2;

import com.amazonaws.services.ec2.model.InstanceState;
import org.brokencodes.tutorials.ada.apis.exceptions.UnknownInstanceStateObtainedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InstanceStateCounterHelperTest {

    @InjectMocks
    private InstanceStateCounterHelper sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void newInstance() {
        InstanceStateCounterHelper helper = InstanceStateCounterHelper.newInstance();
        assertThat(helper).isNotNull();
        assertThat(helper.get()).isNotNull();
    }

    @Test
    void incrementCount() {

        InstanceState mockedInstanceState = mock(InstanceState.class);

        // PENDING
        when(mockedInstanceState.getCode()).thenReturn(0);
        testInstanceStateCount(1, mockedInstanceState);

        // RUNNING
        when(mockedInstanceState.getCode()).thenReturn(16);
        testInstanceStateCount(1, mockedInstanceState);

        // SHUTTING_DOWN
        when(mockedInstanceState.getCode()).thenReturn(32);
        testInstanceStateCount(1, mockedInstanceState);

        // TERMINATED
        when(mockedInstanceState.getCode()).thenReturn(48);
        testInstanceStateCount(1, mockedInstanceState);

        // STOPPING
        when(mockedInstanceState.getCode()).thenReturn(64);
        testInstanceStateCount(1, mockedInstanceState);

        // STOPPED
        when(mockedInstanceState.getCode()).thenReturn(80);
        testInstanceStateCount(1, mockedInstanceState);

        // Exception
        InstanceStateCounterHelper instanceStateCounterHelper = InstanceStateCounterHelper.newInstance();
        when(mockedInstanceState.getCode()).thenReturn(-1);
        UnknownInstanceStateObtainedException obtainedException = assertThrows(
                UnknownInstanceStateObtainedException.class,
                () -> instanceStateCounterHelper.incrementCount(mockedInstanceState)
        );

        assertThat(obtainedException).hasMessage("An unknown instance state: -1 was obtained.");
    }

    @Test
    void get() {
        InstanceStateCounterHelper helper = InstanceStateCounterHelper.newInstance();
        assertThat(helper).isNotNull();
    }

    private void testInstanceStateCount(int actual, InstanceState mockedInstanceState) {
        InstanceStateCounterHelper instanceStateCounterHelper = InstanceStateCounterHelper.newInstance();
        assertThat(instanceStateCounterHelper.get()).isNotNull();
        instanceStateCounterHelper.incrementCount(mockedInstanceState);
        assertThat(actual).isEqualTo(1);
        assertThat(instanceStateCounterHelper.get().getCountTotal()).isEqualTo(1);
    }

}