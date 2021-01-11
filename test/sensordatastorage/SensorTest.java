package sensordatastorage;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SensorTest {
    @Test
    public void addMeasurement_test_valid_any_measurement_was_added() throws Exception {
        String sensorTestName = "Name";
        int timestampTest = 1;
        float dataTest = 1.0f;
        Sensor sensor = new SensorImpl(sensorTestName);

        sensor.addMeasurement(timestampTest, dataTest);

        Assert.assertNotNull(sensor.getMeasurements()[0]);
    }

    @Test
    public void addMeasurement_test_valid_correct_measurement_timestamp_was_added() throws Exception {
        String sensorTestName = "Name";
        long expectedTimestamp = 1;
        float expectedData = 1.0f;
        Sensor sensor = new SensorImpl(sensorTestName);
        sensor.addMeasurement(expectedTimestamp, expectedData);

        long currentTimestamp = sensor.getMeasurements()[0].getTimestamp();

        Assert.assertEquals(currentTimestamp, expectedTimestamp);
    }

    @Test
    public void addMeasurement_test_valid_correct_measurement_data_was_added() throws Exception {
        String sensorTestName = "Name";
        long expectedTimestamp = 1;
        float expectedData = 1.0f;
        float errormargine = 0.0f;

        Sensor sensor = new SensorImpl(sensorTestName);
        sensor.addMeasurement(expectedTimestamp, expectedData);

        float currentData = sensor.getMeasurements()[0].getData();

        Assert.assertEquals(currentData, expectedData, errormargine);
    }

    @Test
    public void addMeasurement_test_valid_multipleMeasurements_Data() throws Exception {
        // establishing the preconditions
        String sensorTestName = "Name";
        long dummyTimestamp = 1;
        float dummyData = 1.0f;
        long expectedTimestamp = 2;
        float expectedData = 2.0f;
        float errormargine = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);


        // executing the tested function and thereby creating the results
        sensor.addMeasurement(dummyTimestamp, dummyData);
        sensor.addMeasurement(expectedTimestamp, expectedData);

        // validating the results
        Measurement actualMeasurement = sensor.getMeasurements()[1];
        Assert.assertEquals(expectedData, actualMeasurement.getData(), errormargine);
    }

    @Test
    public void addMeasurement_test_valid_multipleMeasurements_Timestamp() throws Exception {
        // establishing the preconditions
        String sensorTestName = "Name";
        long dummyTimestamp = 1;
        float dummyData = 1.0f;
        long expectedTimestamp = 2;
        float expectedData = 2.0f;
        float errormargine = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);


        // executing the tested function and thereby creating the results
        sensor.addMeasurement(dummyTimestamp, dummyData);
        sensor.addMeasurement(expectedTimestamp, expectedData);

        // validating the results
        Measurement actualMeasurement = sensor.getMeasurements()[1];
        Assert.assertEquals(expectedTimestamp, actualMeasurement.getTimestamp());
    }

    @Test
    public void addMeasurement_test_edgecase_data_lower() throws Exception {
        //establishing the preconditions
        String sensorTestName = "name";
        long dummyTimestamp = 1;
        float expectedData = Float.MIN_VALUE;
        float errormargine = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);

        //executing the tested function and thereby creating the results
        sensor.addMeasurement(dummyTimestamp, expectedData);
        float actualData = sensor.getMeasurements()[0]
                .getData();

        //validating the results
        Assert.assertEquals(expectedData, actualData, errormargine);
    }

    @Test
    public void addMeasurement_test_edgecase_data_upper() throws Exception {
        //establishing the preconditions
        String sensorTestName = "name";
        long dummyTimestamp = 1;
        float expectedData = Float.MAX_VALUE;
        float errormargine = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);

        //executing the tested function and thereby creating the results
        sensor.addMeasurement(dummyTimestamp, expectedData);
        float actualData = sensor.getMeasurements()[0]
                .getData();

        //validating the results
        Assert.assertEquals(expectedData, actualData, errormargine);
    }


    @Test
    public void addMeasurement_test_edgecase_timestamp_lower() throws Exception {
        //establishing the preconditions
        String sensorTestName = "name";
        long timestampExpected = 0L;
        float dummyData = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);

        //executing the tested function and thereby creating the results
        sensor.addMeasurement(timestampExpected, dummyData);
        long TimeStampActual = sensor.getMeasurements()[0].getTimestamp();
        //validating the results
        Assert.assertEquals(timestampExpected, TimeStampActual);
    }

    @Test
    public void addMeasurement_test_edgecase_timestamp_upper() throws Exception {
        //establishing the preconditions

        String sensorTestName = "name";
        long timestampExpected = System.currentTimeMillis();
        float dummyData = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);

        //executing the tested function and thereby creating the results
        sensor.addMeasurement(timestampExpected, dummyData);
        long TimeStampActual = sensor.getMeasurements()[0].getTimestamp();
        //validating the results
        Assert.assertEquals(timestampExpected, TimeStampActual);
    }

    @Test
    public void addMeasurement_test_edgecase_measurements_full() throws Exception {
        //establishing the preconditions
        String sensorTestName = "name";
        long timestampDummy = System.currentTimeMillis();
        float dataDummy = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);
        short counter = 100;
        //executing the tested function and thereby creating the results
        while (counter-- != 0) {
            sensor.addMeasurement(timestampDummy, dataDummy);
        }
        //validating the results
        Assert.assertNotNull(sensor.getMeasurements()[99]);
    }

    @Test(expected = IllegalArgumentException.class)

    public void addMeasurement_test_invalid_timestamp_before_1970() throws Exception {
        //establishing the preconditions
        String sensorTestName = "name";
        long wrongTimestamp = -1;
        float dataDummy = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);
        //executing the tested function and thereby creating the results
        sensor.addMeasurement(wrongTimestamp, dataDummy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMeasurement_test_invalid_timestamp_after_now() throws Exception {
        //establishing the preconditions
        String sensorTestName = "name";
        long wrongTimestamp = System.currentTimeMillis() + 10000;
        float dataDummy = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);
        //executing the tested function and thereby creating the results
        sensor.addMeasurement(wrongTimestamp, dataDummy);
        //validating the results
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void addMeasurement_test_invalid_measurements_full() {
        //establishing the preconditions
        String sensorTestName = "name";
        long timestampDummy = System.currentTimeMillis();
        float dataDummy = 0.0f;
        Sensor sensor = new SensorImpl(sensorTestName);
        short counter = 101;
        //executing the tested function and thereby creating the results
        while (counter-- != 0) {
            sensor.addMeasurement(timestampDummy, dataDummy);
        }
    }

    /*
    EdgeCases:
        Timestamp
          x 1970 - EPOCH
          x now
        float
          x max negative
          x max positive
        measurements[]
          x full
    */

    /*
    Invalids:
        Timestamp
          x before 1900
          x in the future
          ? not long
            null
        data
        measurements[]
            add when full
     */

    /* This is a simple template for a testcase
    @Test
    public void changeMyName() {
        //establishing the preconditions

        //executing the tested function and thereby creating the results

        //validating the results
    }
    */
}
