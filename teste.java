package pacote;

/**
 *
 * @author nelson.correa@unimedsaocarlos.local
 *
 */
public class teste {

    public teste() {
    }

    private int prop1;
    public int getProp1() {
        return prop1;
    }

    public void setProp1(int prop1) {
        this.prop1 = prop1;
    }

    private String prop2;
    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    private float prop3;
    public float getProp3() {
        return prop3;
    }

    public void setProp3(float prop3) {
        this.prop3 = prop3;
    }


    public int getProp1() {
        return prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public float getProp3() {
        return prop3;
    }

    public void setProp1(int prop1) {
        this.prop1 = prop1;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public void setProp3(float prop3) {
        this.prop3 = prop3;
    }

    @Override
    public String toString() {
        return "teste{" + "prop1=" + prop1 + ", " + "prop2=" + prop2 + ", " + "prop3=" + prop3 + ", " + '}';
    }

}
