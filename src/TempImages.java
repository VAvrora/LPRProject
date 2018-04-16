import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TempImages {

	private JFrame frame;
	private JPanel panelTools;
	private JTable table;
	private JScrollPane panelImages;// = new JScrollPane();
	private JLabel JLabelPicture;
	private ArrayList<oneLPRImage> pictures = new ArrayList<oneLPRImage>();
	private ArrayList<JLabel> JLabelPictures = new ArrayList<JLabel>();
	private oneLPRImage singleImage;
	int imageSize;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempImages window = new TempImages();
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
	public TempImages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		//JScrollPane panelImages = new JScrollPane();
		panelImages = new JScrollPane();
		frame.getContentPane().add(panelImages, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Open");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmImage = new JMenuItem("Image");		
		mnNewMenu_1.add(mntmImage);
		
		JMenuItem mntmFiles = new JMenuItem("Files");
		mnNewMenu_1.add(mntmFiles);
		
		mntmFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panelImages.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				//panelImages.removeAll();
				JFileChooser jc = new JFileChooser();
				jc.setDialogTitle("Pleae select wanted pictures");
				jc.setMultiSelectionEnabled(true);
				jc.setFileFilter(new FileNameExtensionFilter(".png","PNG"));
				if(jc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					File[] imgs = jc.getSelectedFiles();
					for (File img: imgs) {
						
						pictures.add(new oneLPRImage(img));
						JLabel tempJLabel = new JLabel(pictures.get(pictures.size()-1).ScaleImage(300));
						
					/*	tempJLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								
								//panelImages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
								panelImages.removeAll();
								singleImage = new oneLPRImage(img);
						
								JLabelPicture.setIcon(singleImage.ScaleImage(panelImages.getHeight()));// = new JLabel(new ImageIcon(scaleImage));
								panelImages.add(JLabelPicture);
								panelImages.revalidate();
								panelImages.repaint();
							}
						});*/
						
						
						JLabelPictures.add(tempJLabel);
						panelImages.add(tempJLabel);
					}
					
					panelImages.revalidate();
					panelImages.repaint();
				}
			}
		});
		
		
	}

}
