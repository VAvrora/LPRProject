import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Component;

public class LPRImages {

	private JFrame frame;
	private JPanel panelTools;
	private JTable table;
	private JPanel panelImages;
	private JLabel JLabelPicture;
	private Image oneImage;
	private int imageProportion;
	private ArrayList<LPRImage> pictures;
	private LPRImage singleImage;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LPRImages window = new LPRImages();
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
	public LPRImages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1142, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		//JLabel JLabelPicture = new JLabel();
		

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
		
		panelTools = new JPanel();
		panelTools.setBorder(null);
		frame.getContentPane().add(panelTools, BorderLayout.NORTH);
		
		JComboBox comboSign = new JComboBox();
		comboSign.setModel(new DefaultComboBoxModel(new String[] {"Sign 1", "Sign 2", "Sign 3", "Sign 4", "Sign 5", "Sign 6", "Sign 7", "Sign 8"}));
		
		JRadioButton rdbtnDetailed = new JRadioButton("Detailed Estimate");
		
		JRadioButton rdbtnSimple = new JRadioButton("Simple Estimate");
		
		ButtonGroup estimate = new ButtonGroup();
		estimate.add(rdbtnSimple);
		estimate.add(rdbtnDetailed);
		
		
		JComboBox comboGrade = new JComboBox();
		panelTools.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelTools.add(comboSign);
		panelTools.add(rdbtnDetailed);
		panelTools.add(rdbtnSimple);
		panelTools.add(comboGrade);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(new Color(0, 0, 0));
		panelTools.add(toolBar);
		
		JButton buttonZoomIn = new JButton("");
		
		
		JLabel lblTools = new JLabel("TOOL BAR:");
		toolBar.add(lblTools);
		buttonZoomIn.setIcon(new ImageIcon(LPRImages.class.getResource("/imgResorse/zoom-tool.png")));
		toolBar.add(buttonZoomIn);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		JButton buttonZoomOut = new JButton("");
		buttonZoomOut.setIcon(new ImageIcon(LPRImages.class.getResource("/imgResorse/zoom-out.png")));
		toolBar.add(buttonZoomOut);
		
		JButton buttonLine = new JButton("");
		buttonLine.setIcon(new ImageIcon(LPRImages.class.getResource("/imgResorse/scribble.png")));
		toolBar.add(buttonLine);
		
		JButton buttonElipse = new JButton("");
		buttonElipse.setIcon(new ImageIcon(LPRImages.class.getResource("/imgResorse/ellipse.png")));
		toolBar.add(buttonElipse);
		
		JButton buttonMarker = new JButton("");
		buttonMarker.setIcon(new ImageIcon(LPRImages.class.getResource("/imgResorse/001-highlighter.png")));
		toolBar.add(buttonMarker);
		
		JSeparator separator1 = new JSeparator();
		separator1.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator1);
		
		JButton buttonEraser = new JButton("");
		buttonEraser.setIcon(new ImageIcon(LPRImages.class.getResource("/imgResorse/001-eraser.png")));
		toolBar.add(buttonEraser);
		
		JButton buttonUndo = new JButton("");
		buttonUndo.setIcon(new ImageIcon(LPRImages.class.getResource("/imgResorse/002-undo-arrow.png")));
		toolBar.add(buttonUndo);
		
		JButton buttonRedo = new JButton("");
		buttonRedo.setIcon(new ImageIcon(LPRImages.class.getResource("/imgResorse/001-redo-arrow.png")));
		toolBar.add(buttonRedo);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		toolBar.add(btnSave);
		
		table = new JTable();
		panelTools.add(table);
		
		rdbtnDetailed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboGrade.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
			}
		});
		
		rdbtnSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboGrade.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
			}
		});
		
		panelImages = new JPanel();
		frame.getContentPane().add(panelImages, BorderLayout.CENTER);
		
		/*JPanel panelOneImage = new JPanel();
		panelOneImage.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelImages.add(panelOneImage);
		panelOneImage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));*/
	
		mntmFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImages.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
				panelImages.removeAll();
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
						panelImages.add(JLabelPicture);
						JLabelPicture.addMouseListener(new MouseListener() {

							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
								
								
								Image scaleImage = image.getImage().getScaledInstance(600,600, Image.SCALE_DEFAULT);
								JLabel JLabelPicture = new JLabel(new ImageIcon(scaleImage));
								//panelOneImage.add(JLabelPicture);
								//panelOneImage.revalidate();
								//panelOneImage.repaint();
								
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}
							
						});
						
					}
					panelImages.revalidate();
					panelImages.repaint();
				}
			}
		});
		
		JLabelPicture = new JLabel();
		

		
		mntmImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				panelImages.removeAll();
				JFileChooser jc = new JFileChooser();
				jc.setDialogTitle("Pleae select wanted pictures");
				jc.setMultiSelectionEnabled(false);
				jc.setFileFilter(new FileNameExtensionFilter(".png","PNG"));
				if(jc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					File picture = jc.getSelectedFile();
					ImageIcon image = new ImageIcon(picture.getAbsolutePath());
					int imageHeight = image.getIconHeight();
					int imageWidth = image.getIconWidth();
					imageProportion = imageWidth/imageHeight;
					oneImage = image.getImage().getScaledInstance(panelImages.getWidth()*imageProportion,panelImages.getHeight(), Image.SCALE_DEFAULT);
					JLabelPicture.setIcon(new ImageIcon(oneImage));// = new JLabel(new ImageIcon(scaleImage));
					panelImages.add(JLabelPicture);
					panelImages.revalidate();
					panelImages.repaint();
				}
			}
		});
		
		//oneImage.getScaledInstance((int) (panelImages.getWidth()*imageProportion), panelImages.getHeight(), Image.SCALE_DEFAULT);
		
		buttonZoomIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
			}
		});
		
	
	}
}
