package com.lear.entity;

import com.lear.body.BallFrame;

import java.awt.*;

/**
 * 弹球实体类
 * @author 天狗
 */
public class Ball extends Thread {

    private Color color;
    private int x;
    private int y;
    private int radius;
    private int speedX;
    private int speedY;
    private BallFrame frame;
    private int id;

    /**
     * @param color 颜色
     * @param x x坐标
     * @param y y坐标
     * @param radius    半径
     * @param speedX    x方向速度
     * @param speedY    y方向速度
     * @param frame    窗体
     * @param id    编号
     */
    public Ball(Color color, int x, int y, int radius, int speedX, int speedY, BallFrame frame, int id) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speedX = speedX;
        this.speedY = speedY;
        this.frame = frame;
        this.id = id;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            if (this.frame.isEnd()) {
                break;
            }
            this.x += this.speedX;
            this.y += this.speedY;
            if (this.x <= 0 || this.x >= this.frame.getWidth() - this.radius) {
                this.speedX = -this.speedX;
            }
            if (this.y <= 0 || this.y >= this.frame.getHeight() - this.radius) {
                this.speedY = -this.speedY;
            }
            this.frame.repaint();
            this.crash();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void crash() {
        this.frame.setEnd(this.frame.getMouse().getX()+this.frame.getMouse().getWidth()/2 >= this.x && this.frame.getMouse().getX()-this.frame.getMouse().getWidth()/2 <= this.x + this.radius
                && this.frame.getMouse().getY()+this.frame.getMouse().getHeight()/2 >= this.y && this.frame.getMouse().getY()-this.frame.getMouse().getHeight()/2 <= this.y + this.radius);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public BallFrame getFrame() {
        return frame;
    }

    public void setFrame(BallFrame frame) {
        this.frame = frame;
    }

}
