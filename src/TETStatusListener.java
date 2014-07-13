import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * Overrides StatusListener interface with custom functionality.
 * 
 * @author Thomas Clark
 */
public final class TETStatusListener implements StatusListener {

    private final TETDataModel model;

    /**
     * Default constructor.
     */
    public TETStatusListener(TETDataModel model) {
        this.model = model;
    }

    /**
     * Function to tell if the input tweet (string) contains a smiley face
     * (happy). If it does not, it is assumed that it contains a frowny face.
     * 
     * @param input
     *            the input string containing the tweet content
     * 
     * @return a boolean that is true if the tweet contains a smiley face.
     */
    private static boolean isHappy(String input) {
        boolean isHappy = false;
        if (input.contains(new StringBuilder(":)"))
                || input.contains(new StringBuilder("(:"))) {
            isHappy = true;
        }
        return isHappy;
    }

    @Override
    public void onStatus(Status status) {

        if (isHappy(status.getText())) {
            this.model.incrementSmileCount();
        } else {
            this.model.incrementFrownCount();
        }

        int smileCount = this.model.smileCount();
        int frownCount = this.model.frownCount();
        double ratio = (double) smileCount / frownCount;

        System.out.println("Smile Count: " + smileCount + "  Frown Count: "
                + frownCount + "  Ratio: " + ratio);
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
//        System.out.println("Got a status deletion notice id:"
//                + statusDeletionNotice.getStatusId());
    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
//        System.out.println("Got track limitation notice:"
//                + numberOfLimitedStatuses);
    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {
//        System.out.println("Got scrub_geo event userId:" + userId
//                + " upToStatusId:" + upToStatusId);
    }

    @Override
    public void onException(Exception ex) {
//        ex.printStackTrace();
    }

    @Override
    public void onStallWarning(StallWarning arg0) {
        // TODO Auto-generated method stub
    }
}
