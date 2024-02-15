package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    /* 설명.
     *  타겟 클래스의 메소드에서 어드바이스를 적용할 수 있는 지점들을 조인포인트(joinpoint)라고 한다.
     *  포인트컷(pointcut)은 여러 조인포인트들에 어드바이스(advice)를 적용할 곳을 지정한 것이다.
     *  해당 조인포인트에서 어드바이스가 동작한다.
     *
     * 설명.
     *  <포인트컷 표현식>
     *  execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
     *  1. 수식어 : public, private 등 수식어를 명시(생략 가능)
     *  2. 리턴 타입 : 리턴 타입을 명시
     *  3. 클래스 이름(패키지명 포함) 및 메소드 이름 : 클래스이름과 메소드 이름을 명시
     *  4. 파라미터(매개변수) : 메소드의 파라미터를 명시
     *  5. " * " : 1개이면서 모든 값이 올 수 있음
     *  6. " .. " : 0개 이상의 모든 값이 올 수 있음
     *
     * 설명.
     *  ex)
     *   execution(public Integer com.ohgiraffers.section01.advice.*.*(*))
     *   => com.ohgiraffers.section01.advice 패키지에 속해 있는 바로 다음 하위 클래스에 파라미터가 1개인 모든 메소드
     *      이자 접근 제어자가 public이고 반환형이 Integer인 경우
     *   execution(* com.ohgiraffers.section01.advice.annotation..stu*(..))
     *   => com.ohgiraffers.section01.advice 패키지 및 하위 패키지에 속해 있고 이름이 stu로 시작하는 파라미터가 0개
     *      이상인 모든 메소드이며 접근제어자와 반환형은 상관없음
    * */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut(){}

    /* 설명. 1. Before Advice */
    /* 설명.
     *  매개변수로 쓰인 JoinPoint
     *  : 포인트 컷으로 패치된 조인 포인트
     *
    * */
//    @Before("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){
//        System.out.println("Before Advice 동작");
        System.out.println("Before joinpoint.getTarget():" + joinPoint.getTarget());
        System.out.println("Before joinpoint.getSignature():" + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){       // 타겟 메소드의 매개변수가 하나 이상이면
            System.out.println("Before joinPoint.getArgs()[0]:" + joinPoint.getArgs()[0]);
        }
    }


    @After("LoggingAspect.logPointcut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After Advice 동작");
        System.out.println("After joinpoint.getTarget():" + joinPoint.getTarget());
        System.out.println("After joinpoint.getSignature():" + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){       // 타겟 메소드의 매개변수가 하나 이상이면
            System.out.println("After joinPoint.getArgs()[0]:" + joinPoint.getArgs()[0]);
        }
    }

    /* 설명. 3. AfterReturning Advice */
    /* 설명. Pointcut에 해당하는 위치가 담긴 메소드가 같은 클래스에 있으면 클래스 소속을 안 적어도 된다. */
    /* 설명. returning에 쓰인 이름이 반환값이 넘어오는 매개변수명과 일치해야 한다.(result) */
    @AfterReturning(pointcut = "logPointcut()", returning="result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("After Returning result : " + result);

        /* 설명. AfterReturning Advice를 활용한 반환값 가공도 가능하다. */
        if(result != null && result instanceof List){
            ((List<MemberDTO>)result).add(new MemberDTO(3L, "반환 값 가공"));
        }
    }

    /* 설명. 4. AfterThrowing Advice */
    /* 설명. throwing 속성 값과 매개변수명이 일치해야한다.(exception) */
    @AfterThrowing(pointcut = "logPointcut()",throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("After Throwing exception : " + exception);
    }

    /* 설명. 5. Around Advice */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint){
        Object result = null;

        return result;
    }
}
