package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {
    private static final double LOW_PRESSURE = 14.00;
    private static final double HIGH_PRESSURE = 25.00;
    private static final double NORMAL_PRESSURE = 18.00;

    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void setup(){
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }


    @Test
    public void testAlarmShouldBeOnBecauseLowPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnBecauseHeightPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testAlarmShouldBeOff(){
        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}