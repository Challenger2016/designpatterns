package com.study.designpatterns.templatemethod;

public class LOLGame extends AbstractGame {

    public LOLGame(String userName, String gameName){
        super.userName = userName;
        super.gameName = gameName;
    }
    @Override
    void run() {
        System.out.println(super.userName + "已打爆敌方水晶");
    }
}
