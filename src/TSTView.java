import java.awt.event.ActionListener;

/**
 * TETView interface that implements ActionListener
 * 
 * @author Thomas Clark
 */
public interface TSTView extends ActionListener {

    /**
     * Register argument as observer/listener of this
     */
    void registerObserver(TSTController controller);

    /**
     * Updates output display based on String provided as argument.
     */
    void updateDisplay(String output);

}
