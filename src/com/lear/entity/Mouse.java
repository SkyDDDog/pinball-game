package com.lear.entity;

import com.lear.body.BallFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * 鼠标移动监听器
 * @author 天狗
 */
public class Mouse implements MouseMotionListener {

    private BallFrame frame;
    private int height;
    private int width;
    private int x;
    private int y;

    public Mouse(BallFrame frame, int height, int width) {
        this.frame = frame;
        this.height = height;
        this.width = width;
    }

    private void changeMouseLocation(MouseEvent e) {
        Point point = e.getPoint();
        this.setX((int) point.getX()-this.getWidth());
        this.setY((int) point.getY()-3*this.getHeight());
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        this.changeMouseLocation(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.changeMouseLocation(e);
    }

    public BallFrame getFrame() {
        return frame;
    }

    public void setFrame(BallFrame frame) {
        this.frame = frame;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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
}
