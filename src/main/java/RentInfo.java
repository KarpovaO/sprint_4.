

public class RentInfo {
    private String orderDate;
    private String rentalPeriod;
    private SamokatColor color;

    public RentInfo(String orderDate, String rentalPeriod, SamokatColor color) {
        this.orderDate = orderDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }

    public SamokatColor getColor() {
        return color;
    }
}
