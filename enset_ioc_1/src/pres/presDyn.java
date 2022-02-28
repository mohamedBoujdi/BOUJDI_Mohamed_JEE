package pres;

import IDao.IDAO;
import IMetier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presDyn {
    public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(new File("config.txt"));
            String daoClassname=scanner.next();
            String metierClassName=scanner.next();
            Class cdao=Class.forName(daoClassname);
            IDAO dao= (IDAO) cdao.newInstance();
            Class cmetier=Class.forName(metierClassName);
            IMetier metier=(IMetier) cmetier.newInstance();
            Method meth=cmetier.getMethod("setiDao",IDAO.class);
            //Method m=cdao.getMethod("getvalue",null);
            //System.out.println("1: "+m.invoke(dao,null));
            meth.invoke(metier,dao);
            System.out.println("2: "+metier.calcul());
        } catch (Exception e) {
         e.printStackTrace();
        }
    }
    }

