package cn.jarlen.media.sample;

import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/**
 * Created by hjl on 2017/3/16.
 */

public interface ITrackHolder {
    ITrackInfo[] getTrackInfo();
    int getSelectedTrack(int trackType);
    void selectTrack(int stream);
    void deselectTrack(int stream);
}
