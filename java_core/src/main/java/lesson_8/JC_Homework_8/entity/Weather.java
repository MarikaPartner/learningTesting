package lesson_8.JC_Homework_8.entity;

public class Weather {
    private String city;
    private String date;
    private String province;
    private double temperature;
    private String condition;

    public Weather(String city, String province, String date, double temperature, String condition) {
        this.city = city;
        this.province = province;
        this.date = date;
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Погода в городе " +
                city + ", " +
                province + " " +
                date +
                ": температура " + temperature +
                " (градусов Цельсия), " + condition;
    }
}
