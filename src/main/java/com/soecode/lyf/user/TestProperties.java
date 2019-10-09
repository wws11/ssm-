package com.soecode.lyf.user;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/7/8 17:30
 */
public class TestProperties {

   /* public static void main(String[] args) {
        int allday = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner read = new Scanner(System.in);
        System.out.print("请输入年月日，格式如：1970/01/01:");
        String dateStr = read.next();
        String[] dateInt = dateStr.split("/");
        int year = Integer.parseInt(dateInt[0]);
        int month = Integer.parseInt(dateInt[1]);
        int day = Integer.parseInt(dateInt[2]);
        for (int i = 0; i < month - 1; i++) {
            allday += days[i];
        }
        allday += day;
        if ((((year % 4 == 0 && year % 100 == 0) || year % 400 == 0) && month > 2)) {
            allday++;
        }
        System.out.println(month + "月" + day + "是" + year + "年的第" + allday + "天");
    }*/
   public static void main(String[] args) {

       int i1=1;
       Integer  i2=1;
       Integer i3=new Integer(1);
       Integer  i4=Integer.valueOf(1);
       Integer  i5=Integer.valueOf(1);
       System.out.println(i1==i2);//比较的值
       System.out.println(i2==i3);//值何地址的比较
       System.out.println(i2==i4);//值的比较
       System.out.println(i3==i4);//地址和值的比较
       System.out.println(i4==i5);//两个值的比较
       String s1=new String("");
       String s2="";
       String s3="";
       String s4=String.valueOf("");
       String s5=String.valueOf("");
       System.out.println("---------------");
       System.out.println(s1==s2);//s1指向堆中地址，由堆中地址指向常量区s2直接存储在常量区
       System.out.println(s1==s4);//和上面原因相似
       System.out.println(s2==s3);//String不可变的特性在常量区是固定的不变的
       System.out.println(s2==s4);//同上
       System.out.println(s4==s5);//同上
   }
}

