package com.ohgiraffers.section06.singleton;

public class LazySingleton {

    private static LazySingleton lazy;
    private LazySingleton() {}
    /* 설명. Initialization on demand holder idiom (holder에 의한 초기화) */
    /* 설명. JVM의 클래스 초기화 과정에서 보장되는 원자적 특성을 이용해 싱글톤의 초기화 문제에 대한 책임을 JVM에게 떠넘기는 걸 활용함
            클래스 안에 선언한 클래스인 holder에서 선언된 인스턴스는 static이기 때문에 클래스 로딩시점에서 한번만 호출된다.
            또한 final을 사용해서 다시 값이 할당되지 않도록 만드는 방식을 사용한 것 */
//    private static class LazyHolder{
//        public static final LazySingleton instance = new LazySingleton();
//    }
//    public static LazySingleton getInstance(){
//        return LazyHolder.instance;
//    }
    public static LazySingleton getInstance() {
        if(lazy == null){                       // static 변수인 lazy에 한번도 객체가 생성 및 할당된 적이 없다면
            lazy = new LazySingleton();
        }
        return lazy;
    }

}
