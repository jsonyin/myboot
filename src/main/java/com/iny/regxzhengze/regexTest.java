package com.iny.regxzhengze;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * Created by zcy on 2018/2/28.
 */
public class regexTest {

    public static void main(String args[]){

//        String rex2="";
//        System.out.println("2018-12-01-".matches(rex2));

        double result1=0.51111122111111;
                 DecimalFormat df = new DecimalFormat("0.00%");
                 String r = df.format(result1);
                 System.out.println(r);//great

    }
}
