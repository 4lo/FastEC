package com.diabin.latte_core.util.timer;



import java.util.TimerTask;

public class BaseTimerTask extends TimerTask{

    private ITimerListener mITimerlistener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerlistener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerlistener != null) {
            mITimerlistener.onTimer();
        }

    }
}
