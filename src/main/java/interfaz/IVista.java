package interfaz;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public interface IVista {

	void setActionListener(ActionListener actionListener);
	void visible(boolean b);
	void setWindowListener(WindowListener w);
	
}
