package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class AlarmTest {

	private Sensor probe(double v, double... v1) {
		Sensor sensor = mock(PressureSensor.class);
		when(sensor.probeValue()).thenReturn(v);
		return sensor;
	}

	@Test
	public void alarmOnWhenLowPressure() {
		Sensor sensor = probe(16.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void alarmOnWhenHighPressure() {
		Sensor sensor = probe(22.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void alarmOffWhenRightPressure() {
		Sensor sensor = probe(19.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	public void alarmOnWhenAlarmActivateOnce() {
		Sensor sensor = probe(22.0, 19.0);
		Alarm alarm = new Alarm(sensor);

		alarm.check();
		assertTrue(alarm.isAlarmOn());

		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

}
