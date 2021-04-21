import org.testng.Assert;
import org.testng.annotations.Test;
import services.PlayList;
import services.Search;
import services.User;

import java.util.ArrayList;
import java.util.List;



public class ApiTest {

    @Test
    public void TestCase(){
        User user = new User();

        String userId = user.getUserId();

        PlayList playList = new PlayList();
        String playListId = playList.createPlayList(userId);

        Assert.assertTrue(playList.checkPlayListIsNull(playListId));
        Search search = new Search();

        List<String> trackList = new ArrayList<>();
        String track1 = search.searchASong("beat it","track","TR");
        trackList.add(track1);
        String track2 = search.searchASong("partition","track","TR");
        trackList.add(track2);
        String track3 = search.searchASong("diamonds","track","TR");
        trackList.add(track3);

        playList.addATrack(trackList,playListId);
        Assert.assertFalse(playList.checkPlayListIsNull(playListId));

    }






    }



