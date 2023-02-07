package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {
    /**
     * 간단하게 외부 네트워크에 미리 연결하는 객체를 하나 생성한다고 가정해보자.
     * 실제로 네트워크에 연결하는 것은 아니고, 단순히 문자만 출력하도록 했다.
     * 이 NetworkClient 는 애플리케이션 시작 시점에 connect() 를 호출해서 연결을 맺어두어야 하고,
     * 애플리케이션이 종료되면 disconnect() 를 호출해 연결을 끊어야 한다
     */

    private String url;

    public NetworkClient() {

        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + ", message : " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

    // 의존관계 주입이 끝나면 호출
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    // 빈 종료시 호출
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
