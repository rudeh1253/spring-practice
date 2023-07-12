package hello.core.singleton;

public class StatelessService {

    public int order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        return price;
    }
}
