package com.lear;

import com.lear.body.BallFrame;


public class Main {


    public static void main(String[] args) {

        BallFrame ballFrame = new BallFrame(5);
        ballFrame.initUi();
        ballFrame.start();

    }


}

