package com.study.designpatterns.templatemethod;

public class Start {
    public static void main(String[] args) {
        AbstractGame logGame = new LOLGame("张小三", "LOL");
        logGame.start();
        logGame.run();
        logGame.end();

        AbstractGame game = new CrossFireGame("李四", "穿越火线");
        game.start();
        game.run();
        game.end();
    }
}
