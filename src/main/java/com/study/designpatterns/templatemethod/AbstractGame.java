package com.study.designpatterns.templatemethod;

public abstract class AbstractGame {

    String userName;

    String gameName;

    public void start(){
        System.out.println(userName + "开始玩" + gameName);
    }

    abstract void run();

    public void end(){
        System.out.println(userName + "推出了" + gameName);
    }
}
