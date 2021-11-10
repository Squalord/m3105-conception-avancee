package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm {
    private final double lowThreshold;
    private final double highThreshold;

    Sensor sensor;

    boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.alarmOn = false;

        this.lowThreshold = 17;
        this.highThreshold = 21;

    }

    public Alarm() {
        this(new PressureSensor());
    }

    public void check() {
        double value = probeValue();
        check(value);
    }

    private double probeValue() {
        return sensor.probeValue();
    }

    private void check(double value) {
        if (isOutOfBound(value)) {
            alarmOn = true;
        }
    }

    private boolean isOutOfBound(double value) {
        return value < lowThreshold || highThreshold < value;
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
