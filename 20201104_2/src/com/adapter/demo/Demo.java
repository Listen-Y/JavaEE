package com.adapter.demo;

import com.adapter.util.AudioPlayer;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 20:19
 */
public class Demo {

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "**************", "哈哈哈");
        player.play("mp4", "+++++++++++++++", "呵呵呵");
        player.play("vlc", "&&&&&&&&&&&&&&&", "嘻嘻嘻");
        player.play("mp5", "###############", "略略略");
    }
}
