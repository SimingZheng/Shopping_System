package shopping.proxydownload;

import java.util.HashMap;

//1. Remote Service Interface

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}