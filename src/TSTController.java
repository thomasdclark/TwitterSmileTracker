/**
 * Controller interface
 * 
 * @author Thomas Clark
 */
public interface TSTController {

    /**
     * Updates this.view to display this.model.
     */
    void updateViewToMatchModel();

    /**
     * Processes event to reset model.
     */
    void processResetEvent();
}