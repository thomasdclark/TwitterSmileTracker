/**
 * Controller class for MVC
 * 
 * @author Thomas Clark
 */
public final class TSTController2 implements TSTController {

    /**
     * Model object.
     */
    private final TSTDataModel model;

    /**
     * View object.
     */
    private final TSTView view;

    /**
     * Constructor; connects this to the model and view.
     */
    public TSTController2(TSTDataModel model, TSTView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Updates this.view to display this.model.
     */
    @Override
    public void updateViewToMatchModel() {
        boolean happyOrSad = this.model.happyOrSad;
        String happyOrSadString;
        if (happyOrSad) {
            happyOrSadString = "HAPPY :)";
        } else {
            happyOrSadString = "SAD :(";
        }

        String output = "\nTwitter is:\n" + happyOrSadString;

        /*
         * Update the display
         */
        this.view.updateDisplay(output);
    }

    /**
     * Processes event to reset model.
     */
    @Override
    public void processResetEvent() {
        /*
         * Update model in response to this event
         */
        this.model.setSmileCount(0);
        this.model.setFrownCount(0);
        this.model.resetDate();
        this.view.updateDisplay(this.model.date().toString()
                + "\nSmile Count:  0\nFrown Count:  0");
    }
}