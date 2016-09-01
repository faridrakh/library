package libman.views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import libman.dao.MemberDAOImpl;
import libman.models.Member;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewMember extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMember frame = new ViewMember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewMember() {
		setTitle("View Member");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 539, 300);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
					.addGap(7))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addGap(7))
		);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("New button");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Id", "First Name", "Last Name", "DOB", "Address", "Phone", "Username", "Password", "Member Expired"
	            }
	        ));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				Member member = new Member();
				member.setLibId(Integer.valueOf(model.getValueAt(index, 0).toString()));
				member.setFName(model.getValueAt(index, 1).toString());
				member.setLName(model.getValueAt(index, 2).toString());
				member.setDob(model.getValueAt(index, 3).toString());
				member.setAddress(model.getValueAt(index, 4).toString());
				member.setPhone(model.getValueAt(index, 5).toString());
				member.setUsername(model.getValueAt(index, 6).toString());
				member.setPassword(model.getValueAt(index, 7).toString());
				member.setMem_exp(model.getValueAt(index, 8).toString());
				JDesktopPane dp = getDesktopPane();
				EditMember em = new EditMember();
				em.setField(member);
				dp.add(em);
				em.setVisible(true);
			}
		});
		MemberDAOImpl mm = new MemberDAOImpl();
		ArrayList<Member> list = mm.findAllMember();
		Object rowData[] = new Object[9];
	    	for(int i = 0; i < list.size(); i++) {
	    		rowData[0] = list.get(i).getLibId();
	            rowData[1] = list.get(i).getFName();
	            rowData[2] = list.get(i).getLName();
	            rowData[3] = list.get(i).getDob();
	            rowData[4] = list.get(i).getAddress();
	            rowData[5] = list.get(i).getPhone();
	            rowData[6] = list.get(i).getUsername();
	            rowData[7] = list.get(i).getPassword();
	            rowData[8] = list.get(i).getMem_exp();
	            model.addRow(rowData);
	        }
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
