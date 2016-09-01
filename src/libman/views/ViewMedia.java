package libman.views;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import libman.dao.MediaDAOImpl;
import libman.models.Media;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewMedia extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMedia frame = new ViewMedia();
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
	public ViewMedia() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 530, 337);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		table.setModel(new DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Barcode", "Title", "Author", "Year", "Publisher", "Type", "Description"
	            }
	        ));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		MediaDAOImpl mm = new MediaDAOImpl();
		ArrayList<Media> list = mm.findAllMedia();
		Object rowData[] = new Object[7];
	    for(int i = 0; i < list.size(); i++) {
	    	rowData[0] = list.get(i).getBarcode();
	        rowData[1] = list.get(i).getTitle();
	        rowData[2] = list.get(i).getAuthor();
	        rowData[3] = list.get(i).getYear();
	        rowData[4] = list.get(i).getPublisher();
	        rowData[5] = list.get(i).getType();
	        rowData[6] = list.get(i).getDescription();

	        model.addRow(rowData);
	    }
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		int index = table.getSelectedRow();
	    		Media media = new Media();
	    		media.setBarcode(new Integer(model.getValueAt(index, 0).toString()));
				media.setTitle(model.getValueAt(index, 1).toString());
				media.setAuthor(model.getValueAt(index, 2).toString());
				media.setYear(Integer.valueOf(model.getValueAt(index, 3).toString()));
				media.setPublisher(model.getValueAt(index, 4).toString());
				media.setType(model.getValueAt(index, 5).toString());
				media.setDescription(model.getValueAt(index, 6).toString());
				
				JDesktopPane dp = getDesktopPane();
				EditMedia em = new EditMedia();
				em.setField(media);
				dp.add(em);
				em.setVisible(true);
			}
		});
	}
}
