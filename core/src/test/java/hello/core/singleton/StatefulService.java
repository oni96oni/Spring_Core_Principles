package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드 : 공유되는 필드!

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; // 여기가 문제가 되는 지점이다.
    }

    public int getPrice() {
        return price;
    }
}
