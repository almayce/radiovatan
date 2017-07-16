package io.almayce.dev.radiovatan;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by almayce on 15.07.17.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private CustomPlayer player;

    public MainPresenter() {
        player = new CustomPlayer();
        check();
    }

    public void playStream() {
        player.playStream();
    }

    public void stopStream() {
        player.stopStream();
    }

    public boolean isPlaying() {
        return player.isPlaying();
    }

    public void check() {
        Observable.interval(1, TimeUnit.MILLISECONDS)
                .compose(new SchedulersTransformer<>())
                .subscribe(aLong -> {
                    if (aLong % 500 == 0) {
                        if (player.getReady()) {
                            getViewState().enableButton();
                            getViewState().loaded();
                        } else getViewState().disableButton();

                        if (player.isPlaying())
                            getViewState().showStopButton();
                        else getViewState().showPlayButton();
                    }
                });
    }
}
