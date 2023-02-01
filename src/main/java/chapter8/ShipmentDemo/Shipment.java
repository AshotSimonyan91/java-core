package chapter8.ShipmentDemo;

public class Shipment extends BoxWeight{
    double cost;

    public Shipment(Shipment ob) {
        super(ob);
        this.cost = ob.cost;
    }

    public Shipment(double width, double height, double depth, double weight, double cost) {
        super(width, height, depth, weight);
        this.cost = cost;
    }

    public Shipment() {
        super();
        this.cost = -1;
    }

    public Shipment(double len, double m, double cost) {
        super(len, m);
        this.cost = cost;
    }
}
