package sensordatastorage;

public class MeasurementImpl implements Measurement {
    private final long timestamp;
    private final float data;


    public MeasurementImpl(long timestamp, float data) {
        this.timestamp = timestamp;
        this.data = data;
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public float getData() {
        return this.data;
    }
}
