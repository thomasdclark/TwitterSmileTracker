import java.util.Date;

/**
 * Model class to hold data collected from tweet stream.
 * 
 * @author Thomas Clark
 */
public final class TETDataModel {

    /**
     * Model variables.
     */
    int smileCount;
    int frownCount;
    Date startDate;

    /**
     * Default constructor.
     */
    public TETDataModel() {
        /*
         * Initialize model
         */
        this.smileCount = 0;
        this.frownCount = 0;
        this.startDate = new Date();
    }

    /**
     * Reports this.smileCount.
     * 
     * @return this.smileCount
     * @ensures <pre>
     * {@code smileCount = this.smileCount}
     * </pre>
     */
    public int smileCount() {
        return this.smileCount;
    }

    /**
     * Reports this.frownCount.
     * 
     * @return this.frownCount
     * @ensures <pre>
     * {@code frownCount = this.frownCount}
     * </pre>
     */
    public int frownCount() {
        return this.frownCount;
    }

    /**
     * Sets this.smileCount to argument.
     * 
     * @param input
     *            new this.smileCount value
     * @ensures <pre>
     * {@code this.smileCount = input}
     * </pre>
     */
    public void setSmileCount(int input) {
        this.smileCount = input;
    }

    /**
     * Sets this.frownCount to argument.
     * 
     * @param input
     *            new this.frownCount value
     * @ensures <pre>
     * {@code this.frownCount = input}
     * </pre>
     */
    public void setFrownCount(int input) {
        this.frownCount = input;
    }

    /**
     * Increases this.smileCount by one.
     * 
     * @ensures <pre>
     * {@code this.smileCount = *this.smileCount++}
     * </pre>
     */
    public void incrementSmileCount() {
        this.smileCount++;
    }

    /**
     * Increases this.frownCount by one.
     * 
     * @ensures <pre>
     * {@code this.frownCount = *this.frownCount++}
     * </pre>
     */
    public void incrementFrownCount() {
        this.frownCount++;
    }

    /**
     * Reports start date.
     * 
     * @return this.startDate
     * @aliases reference returned by {@code startDate}
     * @ensures <pre>
     * {@code date = this.startDate}
     * </pre>
     */
    public Date date() {
        return this.startDate;
    }

    /**
     * Resets the start date.
     * 
     * @ensures <pre>
     * {@code this.startDate = new Date()}
     * </pre>
     */
    public void resetDate() {
        this.startDate = new Date();
    }
}
