package hello.core.singleton;

public class SingletonService {
    // 자기 자신을 선언한다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
        // 생성자를 private으로 선언하면 외부에서 new를 통해 인스턴스를 생성할 수 없다.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
