import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PasswordChooser extends JPanel {

	private JTextField username;
	private JPasswordField password;
	private JButton okButton;
	private boolean ok;
	private JDialog dialog;

	public PasswordChooser() {
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8, 8));
		panel.add(new JLabel("User Name:"));
		panel.add(username = new JTextField(""));
		panel.add(new JLabel("Password:"));
		panel.add(password = new JPasswordField(""));
		add(panel, BorderLayout.CENTER);

		okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ok = true;
				dialog.setVisible(false);
			}
		});

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dialog.setVisible(false);
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public void setUser(User u) {
		username.setText(u.getName());
	}

	public User getUser() {
		return new User(username.getText(), password.getPassword());
	}
	
	public boolean showDialog(Component parent, String title)
	{
		ok = false;
		Frame owner = null;
		if (parent instanceof Frame)
			owner = (Frame)parent;
		else
			owner = (Frame)SwingUtilities.getAncestorOfClass(Frame.class, parent);
		if (dialog == null || dialog.getOwner() != owner)
		{
			dialog = new JDialog(owner, true);
			dialog.add(this);
			dialog.getRootPane().setDefaultButton(okButton);
			dialog.pack();
		}
		dialog.setTitle(title);
		dialog.setVisible(true);
		return ok;
	}
}

class User {
	public User(String aName, char[] aPassword) {
		name = aName;
		password = aPassword;
	}
	
	private String name;
	private char[] password;

	public String getName() {
		return name;
	}

	public char[] getPassword() {
		return password;
	}

	public void setName(String aName) {
		name = aName;
	}

	public void setPassword(char[] aPassword) {
		password = aPassword;
	}
}
