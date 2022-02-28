package hu.petrik;

import java.time.LocalDateTime;

public class Fuvar {
    private int id;
    private String start;
    private int travelTime;
    private double travelLength;
    private double price;
    private double tip;
    private String paymentType;

    public Fuvar(String s) {
        s = s.replace(",", ".");
        String[] data = s.split(";");
        this.id = Integer.parseInt(data[0]);
        this.start = data[1];
        this.travelTime = Integer.parseInt(data[2]);
        this.travelLength = Double.parseDouble(data[3]);
        this.price = Double.parseDouble(data[4]);
        this.tip = Double.parseDouble(data[5]);
        this.paymentType = data[6];
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public void setTravelLength(int travelLength) {
        this.travelLength = travelLength;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getId() {
        return id;
    }

    public String getStart() {
        return start;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public double getTravelLength() {
        return travelLength;
    }

    public double getPrice() {
        return price;
    }

    public double getTip() {
        return tip;
    }

    public String getPaymentType() {
        return paymentType;
    }

    @Override
    public String toString() {
        return String.format("%d: %s, length: %d, distance: %.1f mile, price: %.2f, tip: %.2f, method: %s",
                id, start, travelTime, travelLength, price, tip, paymentType);
    }
}