import jdk.jfr.Description;

import java.util.Calendar;

public class Product {

    private String ID;

    private String Name;

    private String Description;

    private double Cost;

    private int year;


    public Product(String ID, String Name, String Description, Double Cost) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Cost = Cost;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Double getCost() {return Cost;}

    public void setCost(double Cost){
        this.Cost = Cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Cost='" + Cost +
                '}';
    }

    public String toCSVDataRecord()
    {
        return ID + ", " + Name + ", " + Description + ", " + Cost;
    }

}
