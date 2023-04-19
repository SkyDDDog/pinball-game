package com.lear.body;

import com.lear.entity.Ball;
import com.lear.entity.GameTimer;
import com.lear.entity.Mouse;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallFrame extends JPanel {

    private List<Ball> ballList;
    private Mouse mouse;
    private boolean endFlag = false;
    private GameTimer timer;

    // 随机数对象
    private final Random random = new Random();

    public BallFrame(int ballNum) {
        this.ballList = new ArrayList<>(ballNum);
        for (int i = 0; i < ballNum; i++) {
            Ball ball = new Ball(
                    new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
                    random.nextInt(600),
                    random.nextInt(600),
                    20+random.nextInt(10),
                    random.nextInt(10),
                    random.nextInt(10),
                    this,
                    i
            );
            ballList.add(ball);
        }
        this.mouse = new Mouse(this, 10, 10);
        timer = new GameTimer();
    }

    public void initUi() {
        JFrame jf = new JFrame("弹球游戏~");
        jf.setSize(new Dimension(600, 600));
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        this.setBackground(Color.WHITE);
        jf.setVisible(true);
        jf.add(this, BorderLayout.CENTER);
        jf.addMouseMotionListener(this.mouse);

    }

    public void start() {
        for (Ball ball : ballList) {
            ball.start();
        }
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("宋体", Font.BOLD, 20));
        g.drawString(timer.format(), 10, 20);
        for (Ball ball : ballList) {
            g.setColor(ball.getColor());
            g.fillOval(ball.getX(), ball.getY(), ball.getRadius(), ball.getRadius());
        }
        this.collision();
        // paint Mouse
        g.setColor(Color.BLACK);
        g.fillRect(this.mouse.getX(), this.mouse.getY(), this.mouse.getWidth(), this.mouse.getHeight());
        if (this.isEnd()) {
            g.setColor(Color.RED);
            g.setFont(new Font("宋体", Font.BOLD, 50));
            g.drawString("游戏结束", 200, 300);
        }
    }

    private void collision() {
        for (int i = 0; i < ballList.size(); i++) {
            for (int j = i + 1; j < ballList.size(); j++) {
                Ball ball1 = ballList.get(i);
                Ball ball2 = ballList.get(j);
                if (ball1.getX() + ball1.getRadius() >= ball2.getX() && ball1.getX() <= ball2.getX() + ball2.getRadius()) {
                    if (ball1.getY() + ball1.getRadius() >= ball2.getY() && ball1.getY() <= ball2.getY() + ball2.getRadius()) {
                        ball1.setSpeedX(-ball1.getSpeedX());
                        ball1.setSpeedY(-ball1.getSpeedY());
                        ball2.setSpeedX(-ball2.getSpeedX());
                        ball2.setSpeedY(-ball2.getSpeedY());
                    }
                }
                ballList.set(i, ball1);
                ballList.set(j, ball2);
            }
        }
    }

    public boolean isEnd() {
        return endFlag;
    }

    public void setEnd(boolean endFlag) {
        this.endFlag = endFlag;
    }

    public Mouse getMouse() {
        return mouse;
    }
}
