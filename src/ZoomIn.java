import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class ZoomIn {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZoomIn window = new ZoomIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ZoomIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		scrollPane.setColumnHeaderView(toolBar);
		
		JPanel panelPictures = new JPanel();
		scrollPane.setViewportView(panelPictures);
		panelPictures.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenu mnOpen = new JMenu("Open");
		mnMenu.add(mnOpen);
		
		JMenuItem mntmImage = new JMenuItem("Image");
		mnOpen.add(mntmImage);
		
		JMenuItem mntmFiles = new JMenuItem("Files");
		mntmFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//scrollPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				panelPictures.removeAll();
				JFileChooser jc = new JFileChooser();
				jc.setDialogTitle("Pleae select wanted pictures");
				jc.setMultiSelectionEnabled(true);
				jc.setFileFilter(new FileNameExtensionFilter(".png","PNG"));
				if(jc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					File[] imgs = jc.getSelectedFiles();
					for (File img: imgs) {
						
						//BufferedImage image = ImageIO.read(picture);
						//pictures
						ImageIcon image = new ImageIcon(img.getAbsolutePath());
						Image scaleImage = image.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
						JLabel JLabelPicture = new JLabel(new ImageIcon(scaleImage));//new ImageIcon(picture.getAbsolutePath()).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT))));
						//JLabelPicture.setIcon((Icon) scaleImage);
						panelPictures.add(JLabelPicture);
					}
				
				}
			}
		});
		mnOpen.add(mntmFiles);
		
		
		mntmImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPictures.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				panelPictures.removeAll();
				JFileChooser jc = new JFileChooser();
				jc.setDialogTitle("Pleae select wanted pictures");
				jc.setMultiSelectionEnabled(false);
				jc.setFileFilter(new FileNameExtensionFilter(".png","PNG"));
				if(jc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					File picture = jc.getSelectedFile();
					ImageIcon image = new ImageIcon(picture.getAbsolutePath());
					int imageHeight = image.getIconHeight();
					int imageWidth = image.getIconWidth();
					int imageProportion = imageWidth/imageHeight;
					Image oneImage = image.getImage().getScaledInstance(panelPictures.getWidth()*imageProportion,panelPictures.getHeight(), Image.SCALE_DEFAULT);
					JLabel JLabelPicture = new JLabel(new ImageIcon(oneImage));
					panelPictures.add(JLabelPicture);
					panelPictures.revalidate();
					panelPictures.repaint();
				}
			}
		});
		
		}
	
}
