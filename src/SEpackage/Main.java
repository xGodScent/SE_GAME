// package
package SEpackage;


// imports
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.net.URI;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


// !~
//////////////////////////////----------------------|
/*///												|
 * 													|
 * @Author: Rio Bérénos								|
 *													|
 *///												|
//////////////////////////////----------------------|
// !~


// [MAIN CLASS]
public class Main extends JFrame {
	
	// [WINDOW ID]
	private static final long serialVersionUID = 9190737483705066505L;
	
	// [JFRAME OBJECTS]
	private JPanel contentPane;
	private JTextField userField;
	private JLabel l2;
	private JPasswordField passField;
	private JTextField userFieldR;
	private JPasswordField passFieldR;
	private JPasswordField passConfirmFieldR;
	private JTextField emailField;
	
	// [MAIN FUNC]
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Main frame = new Main();
					frame.setVisible(true);
					
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	// [GLOBAL DATA]
	public static String user = "default";	// sets user to default user
	public String new_user;					// new_user will be declared when we make a new account
	public static int slot = -1;			// game slot (which save file we want to use)
	
	public int[] dob;						// date of birth in an array: {day, month, year}
	public String e;						// email
	
	public String temp;						// temp (ignore)
	
	
	// LOG (to console) method
	public void log(String toConsole) {
		
		System.out.println("[CONSOLE:~$] : " + toConsole + ";");
		
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	// Main
	public Main() {

		
		LoginScreen();
		
		
	} // public Main()
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	// register
	public void RegisterScreen() {
		// window setup
		getContentPane().removeAll();
		repaint();
		
		setFont(new Font("Fugaz One", Font.PLAIN, 12));
		setTitle("Game:SER:(9190737483705066505L)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel l_7 = new JLabel("   - Optional");
		l_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l_7.setForeground(Color.RED);
		l_7.setBounds(10, 200, 100, 14);
		contentPane.add(l_7);
		
		JLabel l_6 = new JLabel("   - Required: (*)");
		l_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l_6.setForeground(Color.RED);
		l_6.setBounds(10, 11, 100, 14);
		contentPane.add(l_6);
		
		JLabel l_5 = new JLabel("Email:");
		l_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l_5.setForeground(Color.WHITE);
		l_5.setBounds(60, 225, 240, 14);
		contentPane.add(l_5);
		
		emailField = new JTextField();
		emailField.setBounds(60, 243, 240, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel dmyLabel = new JLabel(" Day:                 Month:              Year:\r\n");
		dmyLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dmyLabel.setForeground(Color.WHITE);
		dmyLabel.setBounds(60, 271, 240, 14);
		contentPane.add(dmyLabel);
		
		JSpinner yearSp = new JSpinner();
		yearSp.setModel(new SpinnerNumberModel(2000, 1900, 2020, 1));
		yearSp.setBounds(250, 296, 50, 20);
		contentPane.add(yearSp);
		
		JComboBox monthOpt = new JComboBox();
		monthOpt.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthOpt.setBounds(155, 296, 50, 20);
		contentPane.add(monthOpt);
		
		JComboBox dayOpt = new JComboBox();
		dayOpt.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayOpt.setBounds(60, 296, 50, 20);
		contentPane.add(dayOpt);
		
		JLabel clickableTOS = new JLabel("Terms Of Service");
		clickableTOS.setToolTipText("Click me!");
		clickableTOS.setForeground(Color.YELLOW);
		clickableTOS.setBounds(163, 562, 109, 32);
		contentPane.add(clickableTOS);
		
		JLabel l_4 = new JLabel("______________");
		l_4.setForeground(Color.YELLOW);
		l_4.setBounds(164, 574, 109, 14);
		contentPane.add(l_4);
		
		JButton confirmRegister = new JButton("Confirm Sign Up");
		confirmRegister.setEnabled(false);
		confirmRegister.setFont(new Font("Snap ITC", Font.PLAIN, 13));
		confirmRegister.setBounds(95, 611, 161, 49);
		contentPane.add(confirmRegister);

		JCheckBox confirmTOS = new JCheckBox("<html>I agree with the<br/>Terms Of Service:</html>");
		confirmTOS.setForeground(Color.WHITE);
		confirmTOS.setBackground(new Color(2, 1, 23));
		confirmTOS.setVerticalAlignment(SwingConstants.TOP);
		confirmTOS.setHorizontalAlignment(SwingConstants.LEFT);
		confirmTOS.setBounds(30, 550, 133, 37);
		contentPane.add(confirmTOS);
		
		userFieldR = new JTextField();
		userFieldR.setBounds(60, 58, 240, 20);
		contentPane.add(userFieldR);
		userFieldR.setColumns(10);
		
		passFieldR = new JPasswordField();
		passFieldR.setColumns(10);
		passFieldR.setBounds(60, 112, 240, 20);
		contentPane.add(passFieldR);
		
		passConfirmFieldR = new JPasswordField();
		passConfirmFieldR.setColumns(10);
		passConfirmFieldR.setBounds(60, 166, 240, 20);
		contentPane.add(passConfirmFieldR);
		
		JLabel l_1 = new JLabel("Username: (*)");
		l_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l_1.setForeground(Color.WHITE);
		l_1.setBounds(60, 35, 100, 20);
		contentPane.add(l_1);
		
		JLabel l_2 = new JLabel("Password: (*)");
		l_2.setForeground(Color.WHITE);
		l_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l_2.setBounds(60, 89, 100, 20);
		contentPane.add(l_2);
		
		JLabel l_3 = new JLabel("Confirm password: (*)");
		l_3.setForeground(Color.WHITE);
		l_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		l_3.setBounds(60, 143, 150, 20);
		contentPane.add(l_3);
		
		// bg labels
		JLabel bgLabel1 = new JLabel("");
		bgLabel1.setIcon(new ImageIcon(".\\textures\\LoginBG.png"));
		bgLabel1.setBounds(0, -20, 360, 360);
		contentPane.add(bgLabel1);
		
		JLabel bgLabel2 = new JLabel("");
		bgLabel2.setIcon(new ImageIcon(".\\textures\\LoginBG.png"));
		bgLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		bgLabel2.setBounds(0, 300, 360, 360);
		contentPane.add(bgLabel2);
		
		JLabel bgLabel3 = new JLabel("");
		bgLabel3.setIcon(new ImageIcon(".\\textures\\LoginBG.png"));
		bgLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		bgLabel3.setBounds(0, 501, 360, 360);
		contentPane.add(bgLabel3);
		
		// [ACTION LISTENERS]
		confirmTOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (confirmTOS.isSelected()) {
					
					confirmRegister.setEnabled(true);
					
				} else {
					
					confirmRegister.setEnabled(false);
					
				}
				
			}
		});
		
		clickableTOS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					
					Desktop desktop = Desktop.getDesktop();
					URI url = new URI("https://www.youtube.com/watch?v=g7_VlmEamUQ&ab_channel=MYSWAMP");
					
					desktop.browse(url);

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		confirmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// user related data
				new_user = userFieldR.getText();
				
				String p1 = String.valueOf(passFieldR.getPassword());
				String p2 = String.valueOf(passConfirmFieldR.getPassword());
				
				
				// gets all users
		        File folder = new File(".\\user_data\\login_cookies\\");
		        String[] accounts;
		        accounts = folder.list();
		        
		        boolean found = false;
		        
		        // loop through all accounts
		        for (String account : accounts) {
		        	
		        	// checks if user already exists
		            if (account.equals(new_user + ".account")) {
		            	
		            	// breaks out of loop
		            	found = true;
		            	break;
		            	
		            } // if statement
		            
		            found = false;
		        
		        } // for loop
				
		        
		        // if account doesnt exist, we try to create one
		        if (!found) {
		        
					// checks if passwords match
					if (p1.equals(p2)) {
						
						// exchange passwords
						temp = p1;
						p1 = "";
						p2 = p1;

						// get email
						String Temp = emailField.getText();
						
						// if the email field is not empty
						if (!Temp.equals(null)) {
							
							if (Temp.endsWith("@hotmail.com") || Temp.endsWith("@gmail.com")) {
								
								e = Temp;
								
							} else {
								
								// lets user know that email might not be working
								int option = JOptionPane.showConfirmDialog(null, "This email might not be valid, are you sure you want to continue?", "Email validation", JOptionPane.INFORMATION_MESSAGE);
								
								// if the option is not yes/confirm
								if (option != 0) {
									
									emailField.setText("");
									JOptionPane.showMessageDialog(null, "Please fill in a valid email or continue to sign up without one");
									
								} else {
									e = Temp;
								}
								
							} // else statement
							
						} // if email is not null
						
						
						// get dob (date of birth)
						int[] tEmp = {dayOpt.getSelectedIndex() + 1, monthOpt.getSelectedIndex() + 1, (int) yearSp.getValue()};
						dob = tEmp;
						
						
						// create new userrrr
						// create new user using threading
						CREATE_NEW_USER.start();
						JOptionPane.showMessageDialog(null, "You will have to login with your account in the login screen");
						LoginScreen();
						
					} else {
						
						passFieldR.setText("");
						passConfirmFieldR.setText("");
						
						JOptionPane.showMessageDialog(null, "Passwords don't match. Please re-enter the passwords");
						
					}
					
		        } else {
		        	
		        	userFieldR.setText("");
		        	
		        	JOptionPane.showMessageDialog(null, "User " + new_user + " already exists, please pick another username or sign in");
		        	
		        } // else statement
		        
		        
			}
		});
			
		
	} // RegisterScreen()
	
	
	// login menu/screen
	public void LoginScreen() {
		// window setup
		getContentPane().removeAll();
		repaint();
		
		setFont(new Font("Fugaz One", Font.PLAIN, 12));
		setTitle("Game:SER:(9190737483705066505L)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		loginBtn.setToolTipText("Login");
		loginBtn.setBounds(120, 179, 96, 34);
		contentPane.add(loginBtn);
		
		userField = new JTextField();
		userField.setBounds(89, 57, 168, 30);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel l1 = new JLabel("Username:");
		l1.setForeground(Color.WHITE);
		l1.setBounds(89, 36, 100, 14);
		contentPane.add(l1);
		
		l2 = new JLabel("Password:");
		l2.setForeground(Color.WHITE);
		l2.setBounds(89, 98, 100, 14);
		contentPane.add(l2);
		
		passField = new JPasswordField();
		passField.setBounds(89, 123, 168, 30);
		contentPane.add(passField);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setFont(new Font("Snap ITC", Font.PLAIN, 11));
		registerBtn.setToolTipText("Click 'register' to make an account!");
		registerBtn.setBounds(255, 297, 89, 23);
		contentPane.add(registerBtn);
		
		JLabel incorrectLabel = new JLabel("Username/password is incorrect!");
		incorrectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectLabel.setForeground(Color.WHITE);
		incorrectLabel.setBounds(10, 224, 334, 30);
		contentPane.add(incorrectLabel);
		incorrectLabel.setVisible(false);
		
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(".\\textures\\LoginBG.png"));
		bgLabel.setBounds(0, -20, 360, 360);
		contentPane.add(bgLabel);
		
		
		// [ACTION LISTENERS]
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// get username and pass from jtextfields
					String u = userField.getText() + ".account";
					String p = String.valueOf(passField.getPassword());
					
					// store a list of all file in accounts
					File folder = new File(".\\user_data\\login_cookies");
					File[] accounts = folder.listFiles();
					
					
					// read file
					BufferedReader accReader = new BufferedReader(new FileReader(".\\user_data\\login_cookies\\" + u));
					String line;
					
					// loop through accounts and compare
					for (int i = 0; i < accounts.length; i++) {
						
						if (String.valueOf(accounts[i]).replace(".\\user_data\\login_cookies\\", "").trim().equals(u)) {
							
							// reads file line by line
							while ((line = accReader.readLine()) != null) {
								
								
								if (line.equals("p:" + p)) {
									
									p = "";
									
									user = u.replace(".account", "");
									
									String[] options = {"  1  ", "  2  ", "  3  "};
									while (slot == -1) {
										
										slot = JOptionPane.showOptionDialog(null, "Pick a save slot to load:", "Save slots", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
									
									}
									
									incorrectLabel.setVisible(false);
									
									log("User '" + user + "' logged in");
									
									Game();
									break;
									
								} else {
									incorrectLabel.setVisible(true);
								}
								
								
							} // while
							
						} // if statement
						
					} // for loop
				
					
					
				} catch (Exception err) {
					incorrectLabel.setVisible(true);
				}
				
				
			}
		});
		
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisterScreen();
				
			}
		});	
		
		
	} // LoginScreen()
	

	// GAME window
	public void Game() {
		
		// window setup
		getContentPane().removeAll();
		repaint();
		
		setFont(new Font("Fugaz One", Font.PLAIN, 12));
		setTitle("Game:SER:8231.352.5.1.131_(1L)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel tipsLabel = new JLabel("Tip: ahh, nevermind");
		tipsLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 25));
		tipsLabel.setToolTipText("Useful tips");
		tipsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tipsLabel.setForeground(Color.WHITE);
		tipsLabel.setBounds(107, 432, 508, 156);
		contentPane.add(tipsLabel);
		
		JLabel haha = new JLabel("probably...");
		haha.setHorizontalAlignment(SwingConstants.CENTER);
		haha.setFont(new Font("Snap ITC", Font.PLAIN, 30));
		haha.setBounds(246, 161, 694, 79);
		contentPane.add(haha);
		
		JLabel l1 = new JLabel("Loading resources...");
		l1.setFont(new Font("Snap ITC", Font.PLAIN, 30));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(10, 342, 694, 79);
		contentPane.add(l1);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		quitBtn.setBounds(10, 615, 145, 65);
		contentPane.add(quitBtn);
		
		JLabel tipsBG = new JLabel("");
		tipsBG.setIcon(new ImageIcon("C:\\Users\\rbere\\eclipse-workspace\\SE\\textures\\LoginBG.png"));
		tipsBG.setToolTipText("");
		tipsBG.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 24));
		tipsBG.setHorizontalAlignment(SwingConstants.CENTER);
		tipsBG.setBounds(0, 432, 720, 156);
		contentPane.add(tipsBG);
		
		// loading screen
		JLabel bgLabel = new JLabel("");
		bgLabel.setIcon(new ImageIcon(".\\textures\\Loading.gif"));
		bgLabel.setBounds(0, 0, 720, 720);
		contentPane.add(bgLabel);
		
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				log("Disposed window");
				log("Force-closing game...");
				System.exit(0);
				
			}
		});
		
		
		// goes to actual game (should close we the window now?)
		GameEngine.main(null);
		
	}

	
	// [THREADS]
	Thread CREATE_NEW_USER = new Thread() {
		public void run() {
			
			log("Ran new user thread");
			
			// create new user folder
			File file = new File(".\\user_data\\saves\\" + new_user);
			file.mkdir();
			
			// create account data and save data
			try {
	
				String p = temp;
				FileWriter temp;
				
				// create account file
				File accData = new File(".\\user_data\\login_cookies\\" + new_user + ".account");
				accData.createNewFile();
				
				temp = new FileWriter(accData);
				temp.write("u:" + new_user + "\np:" + p + "\ndob:" + Arrays.toString(dob) + "\ne:" + e);
				p = "";
				temp.close();
				
				// create slot data files
				for (int i = 1; i < 4; i++) {
					
					File dataSet = new File(".\\user_data\\saves\\" + new_user + "\\" + i + ".data");
					dataSet.createNewFile();
					
					temp = new FileWriter(dataSet);
					temp.write("l:3\nk:0\nt:0\nx:360\ny:360");
					temp.close();
					
				}
				
				// create settings file
				File createSettings = new File(".\\user_data\\saves\\" + new_user + "\\game.settings");
				createSettings.createNewFile();
				
				temp = new FileWriter(createSettings);
				temp.write("fpsL:60\nresX:720\nresY:720\nmusic:on\nsound:on");
				temp.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			log("Finished new user thread");
			
		}
			
	};
	
} // Main class
