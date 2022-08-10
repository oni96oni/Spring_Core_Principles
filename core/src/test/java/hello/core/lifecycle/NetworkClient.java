package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스를 시작할때 호출하는 메서드
    public void connect() {
        System.out.println("connect: " + url);

    }

    public void call(String message) {
        System.out.println("call: " + url + ", message = " + message);

    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }
    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient init");
        connect();
        call("초기화 연결 메시지");
        // 의존관계가 다 끝나고 스프링이 호출 해준다.
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
        // 빈이 종료될때 호출, 이렇게 안전하게 내려간 뒤에 스프링이 내려간다.
    }
}
