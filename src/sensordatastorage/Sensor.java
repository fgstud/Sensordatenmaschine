package sensordatastorage;

public interface Sensor {
    /**
     * gets all measurements of the sensor
     * @return an array with all measurements
     */
    public Measurement[] getMeasurements();

    /**
     *
     * @return Name of the Sensor
     */
    public String getSensorName();

    /**
     * saves a measurement into the storage of the Sensor
     * @param timestamp time of data collection
     * @param data data that needs to be saved
     */
    public void addMeasurement(long timestamp, float data) throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
}
