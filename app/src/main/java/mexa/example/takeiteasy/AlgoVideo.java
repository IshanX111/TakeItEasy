package mexa.example.takeiteasy;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class AlgoVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algo_video);

        VideoView videoView=findViewById(R.id.videoView);
        String videoPath="android.resource://"+getPackageName()+"/"+R.raw.bfsish;
        Uri uri= Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        VideoView videoView2=findViewById(R.id.videoView2);
        String videoPath2="android.resource://"+getPackageName()+"/"+R.raw.bfs;
        Uri uri2= Uri.parse(videoPath2);
        videoView2.setVideoURI(uri2);
        MediaController mediaController2=new MediaController(this);
        videoView2.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView2);
    }
}