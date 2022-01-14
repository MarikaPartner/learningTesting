package java_core.lesson_5;

import java.io.Serializable;
import java.util.Arrays;

public class AppData implements Serializable {

    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void printAppData() {
        System.out.println(Arrays.toString(this.header));
        for (int[] datum : this.data) {
            System.out.println(Arrays.toString(datum));
        }
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }
}
