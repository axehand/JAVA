package com.ohgiraffers.section01.insert;

/* 설명. Service 계층은 Connection 객체 생성 및 소멸(close) 비즈니스 로직, 트랜잭션(commit, rollback) 처리 */

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuService {
    public void registMenu(Menu registMenu){
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.registMenu(con, registMenu);
        if(result > 0){
//            con.commit();         //try/catch로 지저분해 지니 JDBCTemplate에 static 메소드로 만들어두자
            commit(con);
        }else{
            rollback(con);
        }

        close(con);
    }
}
