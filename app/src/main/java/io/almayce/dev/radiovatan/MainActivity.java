package io.almayce.dev.radiovatan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import io.almayce.dev.radiovatan.databinding.ActivityMainBinding;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void enableButton() {
        binding.playStop.setEnabled(true);
    }

    @Override
    public void disableButton() {
        binding.playStop.setEnabled(false);

    }

    @Override
    public void showStopButton() {
        binding.playStop.setImageResource(R.drawable.stop_btn);
    }

    @Override
    public void showPlayButton() {
        binding.playStop.setImageResource(R.drawable.play_btn);

    }

    @Override
    public void loaded() {
        binding.loading.setVisibility(View.INVISIBLE);
    }

    public void onPlayStopClick(View view) {
        if (mainPresenter.isPlaying())
            mainPresenter.stopStream();
        else
            mainPresenter.playStream();

    }

    public void onSocialClick(View view) {
        StringBuilder link = new StringBuilder();
        switch (view.getContentDescription().toString()) {
            case "vk": {
                link.append("https://vk.com/radiovatanofficial");
                break;
            }
            case "tw": {
                link.append("https://twitter.com/radiovatan2007");
                break;
            }
            case "fb": {
                link.append("https://www.facebook.com/groups/406423696420524/");
                break;
            }
            case "in": {
                link.append("https://www.instagram.com/radiovatan/");
                break;
            }
            case "yt": {
                link.append("https://www.youtube.com/channel/UC3LM1K3Z__id9QdIHkAd8Tg");
                break;
            }
        }
        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse(link.toString()));
        browserIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        startActivity(browserIntent);
    }
}
