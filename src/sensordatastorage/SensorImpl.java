package sensordatastorage;


import java.util.ArrayList;
import java.util.List;

public class SensorImpl implements Sensor {
    private final String sensorName;

    private Measurement measurements[] = new Measurement[100];
    private int amountOfMeasurements = 0;


    public SensorImpl(String sensorName) {
        this.sensorName = sensorName;
    }

    @Override
    public Measurement[] getMeasurements() {
        return this.measurements;
    }

    @Override
    public String getSensorName() {
        return this.sensorName;
    }

    @Override
    public void addMeasurement(long timestamp, float data) throws  IllegalArgumentException,ArrayIndexOutOfBoundsException{
        if (timestamp < 0) {
            throw new IllegalArgumentException("The timestamp is before UNIX Time (1970)");
        }
        if (timestamp > System.currentTimeMillis()) {
            throw new IllegalArgumentException("The timestamp lies in the future");
        }

        Measurement measurement = new MeasurementImpl(timestamp,data);
        try {
            this.measurements[amountOfMeasurements++] = measurement;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Speicher voll.");
            throw e;
        }

    }
}