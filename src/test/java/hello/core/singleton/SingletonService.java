package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 static으로 선언하여 클래스 레벨에 올라가기 때문에 하나만 존재하게 된다
    private static final SingletonService instance = new SingletonService();
    // 자바가 뜰때 SingletonService에 static영억에 객체가 생성되어 instance에 자기 자신을 넣어둔다
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){    } //private 생성자를 만들어서 객체 생성을 막는다

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출출");
    }



}
