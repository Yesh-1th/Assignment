package utilities;

import pojo.addPodcast;

public class TestDatabuild {


    public addPodcast addPodcastPayLoad(String id, String image, int listen_score)
    {
        addPodcast ap = new addPodcast();
        ap.setId(id);
        ap.setImage(image);
        ap.setListen_score(listen_score);
        ap.setPublisher("dummy");
        ap.setListennotes_url("Dummy");
        ap.setListen_score_global_rank(9);
        ap.setTitle("None");
        ap.setThumbnail("white");
        return ap;
    }

}
