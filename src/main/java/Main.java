import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.dto.tweet.TweetList;
import io.github.redouane59.twitter.dto.tweet.TweetV2;
import io.github.redouane59.twitter.signature.TwitterCredentials;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        TwitterClient twitterClient = new TwitterClient(TwitterClient.OBJECT_MAPPER
                .readValue(new File("credentials.json"), TwitterCredentials.class));


//        UserV2 userV2 = twitterClient.getUserFromUserName("Oiler_gc");
        TweetList tweets = twitterClient.searchTweets("bolsonaro é maluco");
        List<TweetV2.TweetData> tweetList = tweets.getData();
        for (TweetV2.TweetData t : tweetList) {
            System.out.println("@" + t.getUser().getDisplayedName() + " - " +  t.getUser().getId());
            System.out.println(t.getCreatedAt());
            System.out.println(t.getText());
            System.out.println();
        }


    }
}
