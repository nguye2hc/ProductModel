public class ProductTest {
    public static void main(String[] args)
    {

        Product Rice = new Product( "123456", "Rice", "Three Elephant Rice",25.0);

        Rice.setName("Rice");

        System.out.println(Rice.getName());

        System.out.println(Rice);

        System.out.println(Rice.toCSVDataRecord());

    }
}
