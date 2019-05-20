package com.uns.media.widget;


/**
 * 播放器设置接口
 */
public interface IPlayerSetting {
    /**
     * 播放器类型
     */
    enum PLAYER_TYPE{
        PLAYER__AndroidMediaPlayer, //系统播放器
        PLAYER__IjkExoMediaPlayer,  //google基于系统播放器扩展的Exo播放器
        PLAYER__IjkMediaPlayer      //基于ffplay封装的播放器
    }

    /**
     * 音频播放类型
     */
    enum PLAY_AUDIO_TYPE{
        AUDIO_TRACK, //使用AudioTrack播放声音
        AUDIO_OPENSLES // 使用opensles播放声音
    }
    /**
     * 设置播放器类型
     * @param type
     */
    void setPlayerType(PLAYER_TYPE type);
    /**
     * 设置音频播放类型
     * @param type
     */
    void setAudioPlayType(PLAY_AUDIO_TYPE type);

    /**
     * 设置播放器视频是否使用MediaCodec解码
     * @param isUse: true:使用mediacodec解码，否则使用avcodec解码
     */
    void setDecodeVideoUseMediaCodec(boolean isUse);

    /**
     * 是否自动旋转
     * @param autoRotate
     */
    void setVideoAutoRotate(boolean autoRotate);

    /**
     * 对应player option mediacodec-handle-resolution-change
     * @param isChange
     */
    void setMediaCodecHandleResolutionChange(boolean isChange);

    /**
     * 设置视频显示格式
     * @param format
     */
    void setPixelFormat(int format);

    /**
     * 是否可能分离SurfaceTextureView
     * @param enable
     */
    void enableDetachedSurfaceTextureView(boolean enable);

    /**
     * 是否使用datasource
     * @param enable
     */
    void enableUsingMediaDataSource(boolean enable);
}
