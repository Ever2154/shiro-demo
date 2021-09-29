package com.demo.shiro.config;

/**
 * @ClassName Son
 * @Description
 * @Author 黄皓
 * @Date 2021/9/24 11:26
 **/
public class Son extends Father{
    @Override
    public String msg(){
        return "son";
    }

    public static void main(String[] args) {
        Son son=new Son();
        son.print();
    }
}
