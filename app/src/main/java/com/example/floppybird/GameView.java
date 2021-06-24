package com.example.floppybird;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;

    public GameView(Context context) {
        super(context);
        InitView();
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if(!gameThread.isRunning()){
            gameThread = New GameThread(holder);
            gameThread.start();
        }else{
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        if(gameThread.isRunning()){
            gameThread.setIsRunning(false);
            boolean retry = true;
            while (retry){
                try{
                    gameThread.join();
                    retry = false;
                }catch (InterruptedException e){
                }
            }
        }
    }

    public void InitView(){
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);

        gameThread = new GameThread(holder);
    }
}
