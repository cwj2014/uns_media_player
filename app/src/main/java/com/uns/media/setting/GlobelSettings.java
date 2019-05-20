package com.uns.media.setting;

/**
 * 播放器全局默认配置
 */
public class GlobelSettings {
    /**
     * 视频显示类型
     */
    public enum PLAY_VIDEO_VIEW_TYPE{
        NONE_VIEW,    //无视频显示view
        TEXTURE_VIEW,  //基于TextureView实现的视频显示
        SURFACE_VIEW,  //基于GLSurfaceView实现的视频显示
    }
    //
    public static PLAY_VIDEO_VIEW_TYPE video_view_type = PLAY_VIDEO_VIEW_TYPE.SURFACE_VIEW;
}
