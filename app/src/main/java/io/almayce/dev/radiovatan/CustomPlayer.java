package io.almayce.dev.radiovatan;

import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by almayce on 15.07.17.
 */

public class CustomPlayer {
    private final static String stream = "http://stream1.radiostyle.ru:8001/radiovatan";
    private MediaPlayer mediaPlayer;
    private boolean ready = false;

    public CustomPlayer() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        init();
    }

    public void init() {
        ready = false;
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(mp -> {
            mediaPlayer.start();
            ready = true;
        });
    }

    public void playStream() {
        mediaPlayer.start();
    }

    public void stopStream() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    public boolean getReady() {
        return ready;
    }
}
