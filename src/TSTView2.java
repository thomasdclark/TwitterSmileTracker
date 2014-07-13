import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * View class that implements TSTView.
 * 
 * @author Thomas Clark
 */
public final class TSTView2 extends JFrame implements TSTView {

    /**
     * Controller object.
     */
    private TSTController controller;

    /**
     * Constants
     */
    private static final int LINES_IN_TEXT_AREAS = 4,
            LINE_LENGTHS_IN_TEXT_AREAS = 8, ROWS_IN_THIS_GRID = 1,
            COLUMNS_IN_THIS_GRID = 1;

    /**
     * Text areas.
     */
    private final JTextArea displayText;

    /**
     * Default constructor.
     */
    public TSTView2() {

        /*
         * Call JFrame superclass with title
         */
        super("Twitter Smile Tracker");

        /*
         * Create widgets
         */
        this.displayText = new JTextArea("", LINES_IN_TEXT_AREAS,
                LINE_LENGTHS_IN_TEXT_AREAS);

        /*
         * Customize font of text
         */
        Font font = new Font("TimeRoman", Font.BOLD, 30);
        this.displayText.setFont(font);
        this.displayText.setForeground(Color.WHITE);
        this.displayText.setBackground(Color.RED);

        /*
         * Text areas should wrap lines, and outputText should be read-only
         */
        this.displayText.setEditable(false);

        /*
         * Create scroll panes for the text areas
         */
        JScrollPane displayTextScrollPane = new JScrollPane(this.displayText);

        /*
         * Organize main window using grid layout
         */
        this.setLayout(new GridLayout(ROWS_IN_THIS_GRID, COLUMNS_IN_THIS_GRID));

        /*
         * Add scroll panes and button panel to main window
         */
        this.add(displayTextScrollPane);

        /*
         * Start the main application window
         */
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Register argument as observer/listener of this
     */
    @Override
    public void registerObserver(TSTController controller) {
        this.controller = controller;
    }

    /**
     * Updates output display based on String provided as argument.
     */
    @Override
    public void updateDisplay(String output) {
        this.displayText.setText(output);
    }

    /**
     * This view has no buttons so no need to implement actionPerformed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Returns the displayText JTextArea
     */
    @Override
    public JTextArea displayText() {
        return this.displayText;
    }
}
