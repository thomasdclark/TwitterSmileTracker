import java.util.Scanner;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Simple Twitter stream application that recieves a stream of tweets containing smiley faces
 * and frowny faces and outputs them to the console.
 * 
 * @author Thomas Clark
 */
public final class TwitterEmotionTrackerMain {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private TwitterEmotionTrackerMain() {
    }

    /**
     * Main program
     * 
     * @param args
     *            command-line arguments; not used
     */
    public static void main(String[] args) throws TwitterException {

        //OAuth configuration using user input (to be made easier in future)
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        Scanner scan = new Scanner(System.in);
        System.out.print("Consumer Key:  ");
        String consumerKey = scan.next();
        System.out.print("Consumer Secret:  ");
        String consumerSecret = scan.next();
        System.out.print("Access Token:  ");
        String accessToken = scan.next();
        System.out.print("Access Token Secret:  ");
        String accessSecret = scan.next();
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(accessToken);
        cb.setOAuthAccessTokenSecret(accessSecret);

        //Create stream of tweets
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build())
                .getInstance();

        //Determine what to do on each event
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                System.out.println(status.getUser().getName() + " : "
                        + status.getText());
            }

            @Override
            public void onDeletionNotice(
                    StatusDeletionNotice statusDeletionNotice) {
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
            }

            @Override
            public void onStallWarning(StallWarning arg0) {
            }
        };

        //Tell stream what tweets to filter for
        FilterQuery fq = new FilterQuery();
        String keywords[] = { ":)", ":(", "(:", "):" };
        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);
    }
}
