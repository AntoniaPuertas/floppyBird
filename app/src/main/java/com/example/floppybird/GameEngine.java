package com.example.floppybird;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    public BackgroundImage mBackgroundImage;
    public Bird bird;
    public ArrayList<Tube> tubes;
    public Random mRandom;

    public static int gameState;

    public GameEngine(){
        mBackgroundImage = new BackgroundImage();
        bird = new Bird();

        //0 = sin comenzar
        //1 = jugando
        //2 = fin de juego
        gameState = 0;
        tubes = new ArrayList<>();
        mRandom = new Random();
        for(int i = 0 ; i < AppConstants.numberOfTubes ; i++){
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTubes;
            int topTubeOffsetY = AppConstants.minTubeOffsetY + mRandom.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY);
            Tube tube = new Tube(tubeX, topTubeOffsetY);
            tubes.add(tube);
        }
    }

    public void updateAndDrawTubes(Canvas canvas){
        if(gameState == 1){
            for(int i = 0 ; i < AppConstants.numberOfTubes ; i++){
                if(tubes.get(i).getTubeX() <- AppConstants.getBitmapBank().getTubeWidth()){
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() + AppConstants.numberOfTubes * AppConstants.distanceBetweenTubes);
                    int topTubeOffsetY = AppConstants.minTubeOffsetY +
                            mRandom.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1); ;
                    tubes.get(i).setTopTubeOffsetY(topTubeOffsetY);
                }
                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelocity);
                canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop(),
                        tubes.get(i).getTubeX(),
                        tubes.get(i).getTopTubeY(),
                        null);
                canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom(),
                        tubes.get(i).getTubeX(),
                        tubes.get(i).getBottomTubeY(),
                        null);
            }
        }
    }

    public void updateAndDrawableBackgroundImage(Canvas canvas){
        mBackgroundImage.setBackgroundImageX(mBackgroundImage.getBackgroundImageX() - mBackgroundImage.getBackgroundVelocity());
        if(mBackgroundImage.getBackgroundImageX() <- AppConstants.getBitmapBank().getBackgroundWidth()){
            mBackgroundImage.setBackgroundImageX(0);
        }
        canvas.drawBitmap(
                AppConstants.getBitmapBank().getBackground(),
                mBackgroundImage.getBackgroundImageX(),
                mBackgroundImage.getBackgroundImageY(),
                null);

        if(mBackgroundImage.getBackgroundImageX() <- (AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)){
            canvas.drawBitmap(
                    AppConstants.getBitmapBank().getBackground(),
                    mBackgroundImage.getBackgroundImageX() + AppConstants.getBitmapBank().getBackgroundWidth(),
                    mBackgroundImage.getBackgroundImageY(),
                    null);
        }
    }

    public void updateAndDrawBird(Canvas canvas){
        if(gameState == 1){
            if(bird.getBirdX() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBirdHeight())
            || bird.getVelocity() < 0){
                bird.setVelocity(bird.getVelocity() + AppConstants.gravity);
                bird.setBirdY(bird.getBirdY() + bird.getVelocity());
            }
        }

        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(
                AppConstants.getBitmapBank().getBird(currentFrame),
                bird.getBirdX(),
                bird.getBirdY(),
                null);
        currentFrame++;
        if(currentFrame > bird.maxFrame){
            currentFrame = 0;
        }
        bird.setCurrentFrame(currentFrame);
    }
}
