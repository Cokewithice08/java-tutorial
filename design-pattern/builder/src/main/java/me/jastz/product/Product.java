package me.jastz.product;

/**
 * @author zhiwen
 */
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"Product\", " +
                "\"partA\":" + (partA == null ? "null" : "\"" + partA + "\"") + ", " +
                "\"partB\":" + (partB == null ? "null" : "\"" + partB + "\"") + ", " +
                "\"partC\":" + (partC == null ? "null" : "\"" + partC + "\"") +
                "}";
    }
}
