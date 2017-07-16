package io.almayce.dev.radiovatan;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by almayce on 15.07.17.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView  extends MvpView{
    void enableButton();
    void disableButton();
    void showStopButton();
    void showPlayButton();
    void loaded();
}
