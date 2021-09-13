package CurrencyHolder;

import javax.swing.*;
import java.awt.*;

public class Visualizer extends JFrame {
	/**
	 * Constructs a new frame that is initially invisible.
	 * <p>
	 * This constructor sets the component's locale property to the value
	 * returned by <code>JComponent.getDefaultLocale</code>.
	 *
	 * @throws HeadlessException if GraphicsEnvironment.isHeadless()
	 *                           returns true.
	 * @see GraphicsEnvironment#isHeadless
	 * @see Component#setSize
	 * @see Component#setVisible
	 * @see JComponent#getDefaultLocale
	 */
	public Visualizer() throws HeadlessException {
		this.setSize(new Dimension(720,480));
		this.setPreferredSize(new Dimension(1444,480));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();

	}

	@Override
	public void paint(Graphics g) {
		g.drawRect();
	}
}
