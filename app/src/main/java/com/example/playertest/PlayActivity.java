package com.example.playertest;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.uns.media.widget.AndroidMediaController;
import com.uns.media.widget.UnsVideoView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class PlayActivity extends AppCompatActivity {
    private UnsVideoView mVideoView;
    private AndroidMediaController mMediaController;
    private TextView mToastTextView;
    private TableLayout mHudView;
    private DrawerLayout mDrawerLayout;
    private ViewGroup mRightDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        //String mVideoPath = "http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8";
        //String mVideoPath = "https://www.sample-videos.com/video123/mp4/720/big_buck_bunny_720p_10mb.mp4";
        String mVideoPath = "http://qiniu.wedo77.com/Fg15Jb0mSCYAyO2R8dvgkGkSZJ46";

        // init UI
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        ActionBar actionBar = getSupportActionBar();
        mMediaController = new AndroidMediaController(this, false);
//        mMediaController.setSupportActionBar(actionBar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mRightDrawer = (ViewGroup) findViewById(R.id.right_drawer);

        mDrawerLayout.setScrimColor(Color.TRANSPARENT);

        mVideoView = (UnsVideoView)findViewById(R.id.video_view);

        mVideoView.setMediaController(mMediaController);

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mVideoView.setVideoURI(Uri.parse(mVideoPath));
        mVideoView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }
}
