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

    //Model
    private final TETDataModel model;

    //Controller
    private final TETController controller;

    /**
     * Default constructor.
     */
    public TETStatusListener(TETDataModel model, TETController controller) {
        this.model = model;
        this.controller = controller;
    }

    /**
     * Function to tell if the input tweet (string) contains a smiley face
     * (happy). If it does not, it is assumed that it contains a frowny face.
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
        this.controller.updateViewToMatchModel();
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {
    }

    @Override
    public void onException(Exception ex) {
    }

    @Override
    public void onStallWarning(StallWarning arg0) {
    }
}
