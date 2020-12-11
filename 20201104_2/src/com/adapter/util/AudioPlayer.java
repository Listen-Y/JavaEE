package com.adapter.util;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 20:20
 */
public class AudioPlayer {

    public void play(String type, String data, String filename) {
        try {
            MediaAdapter adapter = new MediaAdapter(type);
            adapter.play(data, filename);
        } catch (AdapterException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
