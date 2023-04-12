package org.example;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class DVDService {
    public void list(){
        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            DigitalVideoDiscMapper discMapper=session.getMapper(DigitalVideoDiscMapper.class);
            List<DigitalVideoDisc> list= discMapper.list();
            for(DigitalVideoDisc disc:list){
                System.out.println(disc.toString());
            }
        }finally {
            session.close();
        }
    }

    public int insert(DigitalVideoDisc disc, Scanner scanner){
        boolean check=false;
        System.out.println("Input title: ");
        disc.setTitle(scanner.nextLine());
        System.out.println("Input category: ");
        disc.setCategory(scanner.nextLine());
        System.out.println("Input director: ");
        disc.setDirector(scanner.nextLine());
        while (!check){
            try {
                System.out.println("Input length: ");
                disc.setLength(Integer.parseInt(scanner.nextLine()));
                check=true;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input. Please try again");
            }
        }
        check=false;
        while (!check){
            try {
                System.out.println("Input cost: ");
                disc.setCost(Float.parseFloat(scanner.nextLine()));
                if(disc.getCost()<=0){
                    System.out.println("Invalid input. Please try again");
                    continue;
                }
                check=true;
            }catch (NumberFormatException exception){
                System.out.println("Invalid input. Please try again");
            }
        }

        SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
        try{
            DigitalVideoDiscMapper discMapper=session.getMapper(DigitalVideoDiscMapper.class);
            discMapper.insert(disc);
            session.commit();
        }finally {
            session.close();
        }
        return 1;
    }
}
