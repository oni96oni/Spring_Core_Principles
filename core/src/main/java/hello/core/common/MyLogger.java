package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + " ] " + "[" + requestURL + " ] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = java.util.UUID.randomUUID().toString(); // 절대 겹치지 않는 Unique Id가 만들어진다.
        System.out.println("[" + uuid + " ] request scope bean create: " + this );
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + " ] request scope bean close: " + this );
    }



}
