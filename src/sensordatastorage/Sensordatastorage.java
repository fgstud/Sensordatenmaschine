package sensordatastorage;

public interface Sensordatastorage {
    /**
     * finds the average Data from all sensors
     * @param sensors
     * @return average data from all sensors
     */
    public float findAverageDataAllSensors(Sensor[] sensors);

    /**
     * finds the total number of data entries
     * @param sensor the Sensor
     * @return the amount of dataentries
     */
    public int getSensorDataAmount(Sensor sensor);

    /**
     * finds the average data of a sensor
     * @param sensor
     * @return average data
     */
    public float findAverageDataSingleSensor(Sensor sensor);
}
