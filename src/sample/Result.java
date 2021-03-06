package sample;

import java.io.Serializable;

public class Result implements Serializable {
    private double value;
    private String conversionFlow;

    public Result(double value, String conversionFlow) {
        this.value = value;
        this.conversionFlow = conversionFlow;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getConversionFlow() {
        return conversionFlow;
    }

    public void setConversionFlow(String conversionFlow) {
        this.conversionFlow = conversionFlow;
    }

    @Override
    public String toString() {
        return conversionFlow + " : " + String.format("%.2f", value);
    }
}
