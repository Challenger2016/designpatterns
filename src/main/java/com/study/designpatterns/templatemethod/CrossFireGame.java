package com.study.designpatterns.templatemethod;

public class CrossFireGame extends AbstractGame {

    public CrossFireGame(String userName, String gameName){
        super.userName = userName;
        super.gameName = gameName;
    }

    @Override
    void run() {
        System.out.println(super.userName + "用枪打死了5个人");
    }
}
