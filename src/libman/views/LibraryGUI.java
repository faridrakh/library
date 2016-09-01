package libman.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryGUI {

	private JFrame frmLibrary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryGUI window = new LibraryGUI();
					window.frmLibrary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibraryGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibrary = new JFrame();
		frmLibrary.setTitle("Library");
		frmLibrary.setBounds(100, 100, 532, 300);
		frmLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibrary.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		JDesktopPane desktopPane = new JDesktopPane();
		GroupLayout groupLayout = new GroupLayout(frmLibrary.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
		);
		frmLibrary.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmLibrary.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		JMenu mnNewMenu_1 = new JMenu("Member");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add New Member");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMember am = new AddMember();
				desktopPane.add(am);
				am.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmViewMember = new JMenuItem("View Member");
		mntmViewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMember vm = new ViewMember();
				desktopPane.add(vm);
				vm.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmViewMember);
		
		JMenu mnNewMenu_2 = new JMenu("Media");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmAddNewMedia = new JMenuItem("Add New Media");
		mntmAddNewMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddMedia am = new AddMedia();
				desktopPane.add(am);
				am.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmAddNewMedia);
		
		JMenuItem mntmViewMedia = new JMenuItem("View Media");
		mntmViewMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMedia vm = new ViewMedia();
				desktopPane.add(vm);
				vm.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmViewMedia);
		
		JMenu mnNewMenu_5 = new JMenu("Rent");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Rent");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rent rent = new Rent();
				desktopPane.add(rent);
				rent.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_6);
		
		JMenuItem mntmViewRent = new JMenuItem("View Uncomplete Rent");
		mntmViewRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewRent vr = new ViewRent();
				desktopPane.add(vr);
				vr.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmViewRent);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("View Complete Rent");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCRent vr = new ViewCRent();
				desktopPane.add(vr);
				vr.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_1);
	}
}
