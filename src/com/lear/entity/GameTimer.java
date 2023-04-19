package com.lear.entity;

/**
 * 计时器实体类
 * @author 天狗
 */
public class GameTimer {

    private long startTime;

    public GameTimer() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }


    public String format() {
        long elapsed = System.currentTimeMillis() - startTime;
        int hour, minute, second, milli;
        milli = (int) (elapsed % 1000);
        elapsed = elapsed / 1000;
        second = (int) (elapsed % 60);
        elapsed = elapsed / 60;
        minute = (int) (elapsed % 60);
        elapsed = elapsed / 60;
        hour = (int) (elapsed % 60);
        return String.format("%02d:%02d:%02d %03d", hour, minute, second, milli);
    }



}
