package com.ohgiraffers.section04.assignment.repository;
import com.ohgiraffers.section04.assignment.aggregate.BloodType;
import com.ohgiraffers.section04.assignment.aggregate.MBTI;
import com.ohgiraffers.section04.assignment.aggregate.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 설명. 데이터와 입출력을 위해 만들어지며, 성공 실패 결과를 반환하는 클래스 */
public class MemberRepository {

    private ArrayList<Member> memberList = new ArrayList<>();

    /* 설명. 프로그램이 켜지자 마자(MemberRepository()가 실행되자마자) 파일에 dummy 데이터 추가 및 입력받기 */
    public MemberRepository() {
        ArrayList<Member> members = new ArrayList<Member>();
//        members.add(new Member(1,"user01","pass01",20,new String[]{"발레","수영"}, BloodType.A, MBTI.ENFP));
//        members.add(new Member(2,"user02","pass02",10,new String[]{"게임","영화시청"}, BloodType.B,MBTI.ENTJ));
//        members.add(new Member(3,"user03","pass03",15,new String[]{"음악감상","독서","명상"}, BloodType.O,MBTI.ENTP));

//        saveMembers(members);
//        loadMembers();

//        System.out.println("========= repository에서 회원정보 다 읽어왔는지 확인 =========");
//        for(Member m : memberList){
//            System.out.println(m);
//        }
    }


    /* 설명. 회원이 담긴 ArrayList를 던지면 파일에 출력하는 기능 */
    private void saveMembers(ArrayList<Member> members) {
        File file = new File("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat");
        System.out.println(file.exists());

        ObjectOutputStream oos = null;
        try {
            if(!file.exists()) {
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat")));
            }else{
                oos = new myOutput(new BufferedOutputStream(new FileOutputStream("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat", true)));
            }
                /* */
            for(Member m : members){
                oos.writeObject(m);
            }
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* 설명. 파일로부터 회원 객체들을 입력받아 memberList에 쌓기 */
    private void loadMembers() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/main/java/com/ohgiraffers/section04/assignment/db/memberDB.dat")));

            /* 설명. 파일로부터 모든 회원 정보를 읽어 memberList에 추가(add) */
            while(true){
                memberList.add((Member)(ois.readObject()));
            }
        }catch (EOFException e){
            System.out.println("회원 정보 모두 로딩됨");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null)ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }

    public Member selectMember(int memNo) {
        for(Member m : memberList){
            if(m.getMemNo() == memNo) return m;
        }
        return null;
    }

    public void addMember(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("회원가입");
            System.out.print("ID를 입력하세요 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호를 입력하세요 : ");
            String pwd = sc.nextLine();
            System.out.println("회원 상세정보 입력");
            System.out.print("나이 : ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("취미(복수입력 시 띄어쓰기로 구분) : ");
            String hobbiesInput = sc.nextLine();
            if (hobbiesInput.trim().isEmpty()) {
                System.out.println("취미를 입력하세요.");
                continue; // 반복문 다시 시작
            }
            String[] hobbies = hobbiesInput.split(" ");
            System.out.print("혈액형 (A, B, AB, O 중 하나 입력): ");
            String bloodTypeInput = sc.nextLine().toUpperCase();
            BloodType bloodType = null;
            try {
                bloodType = BloodType.valueOf(bloodTypeInput);
            } catch (IllegalArgumentException e) {
                System.out.println("유효한 혈액형을 입력하세요.");
                continue;
            }
            System.out.print("MBTI를 입력하세요 : ");
            String mbtiInput = sc.nextLine().toUpperCase();
            MBTI mbti = null;
            try{
                mbti = MBTI.valueOf(mbtiInput);
            } catch(IllegalArgumentException e) {
                System.out.println("유효한 MBTI를 입력하세요.");
                continue;
            }
            Member newMember = new Member(memberList.size() + 1, id, pwd, age, hobbies, bloodType, mbti);
            memberList.add(newMember);
            saveMembers(memberList);
            //loadMembers();
            break;
        }
        loadMembers();
    }
}
