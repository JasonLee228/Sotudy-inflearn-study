package hello.core.singleton;

public class SingletonService {

    // 클래스 내부에서 private 로 선언 -> 타 클래스에서 instance 변수?에 접근 불가
    // static 으로 선언 -> 클래스 레벨에서 하나만 존재할 수 있다.
    private static final SingletonService instance = new SingletonService();

    // 이렇게 해두면 프로그램이 실행될 때 static 으로 선언된 instance 에 new 를 통해서 생성된 SingletonService 의 참조값을 넣어둔다.
    public static SingletonService getInstance() { // 이 메소드를 통해서 타 클래스에서 instance 에 접근할 수 있도록 한 것.
        return instance;
    }

    // 생성자를 private 로 선언하게 되면, 외부에서는 SingletonService 자체를 생성하지 못 하도록 막은 것이다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    /*
      1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
      2. 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
      3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다
    */

}
