package com.example.mosahadatv

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player = ExoPlayer.Builder(this).build()
        val playerView = findViewById<StyledPlayerView>(R.id.playerView)
        playerView.player = player

        val m3uUrl = "http://mytvnet.net:2095/get.php?username=7686670927&password=4030453187&type=m3u&output=mpegts"
        
        val mediaItem = MediaItem.fromUri(Uri.parse(m3uUrl))
        player?.setMediaItem(mediaItem)
        player?.prepare()
        player?.play()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}
