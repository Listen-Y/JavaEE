package com.adapter.util;


import com.adapter.model.Mp3Player;
import com.adapter.model.Mp4Player;
import com.adapter.model.VlcPlayer;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 19:42
 */

class AdapterException extends Exception {
    public AdapterException(String message) {
        super(message);
    }
}

public class MediaAdapter implements Player {

    private AdvancedPlayer advancedPlayer;

    public MediaAdapter(String type) throws AdapterException {
        adapter(type);
    }

    private void adapter(String type) throws AdapterException {
        if ("mp3".equalsIgnoreCase(type)) {
            advancedPlayer = new Mp3Player();
        } else if ("mp4".equalsIgnoreCase(type)) {
            advancedPlayer = new Mp4Player();
        } else if ("vlc".equalsIgnoreCase(type)) {
            advancedPlayer = new VlcPlayer();
        } else {
            throw new AdapterException("Type Not Find");
        }
    }

    @Override
    public void play(String data, String fileName) {
        System.out.println(advancedPlayer.getClass().getName() + ": " + fileName + " date:" + data);
    }
}
