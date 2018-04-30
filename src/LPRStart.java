import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

//import Line2D.Double;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
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
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Scrollbar;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class LPRStart
{

	private JFrame frame;
	private JPanel panelTools;
	private JTable table;
	private JPanel panelImages;
	private JLabel JLabelPicture;
	private ArrayList<oneLPRImage> pictures = new ArrayList<oneLPRImage>();
	private ArrayList<JLabel> JLabelPictures = new ArrayList<JLabel>();
	private oneLPRImage singleImage;
	int imageSize;
	public Point prevPoint;
	
	/**
	 * @wbp.nonvisual location=106,-1
	 */
	private final Scrollbar scrollbar = new Scrollbar();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LPRStart window = new LPRStart();
					window.frame.setVisible(true);
					//window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//JLabelPicture.setIcon(singleImage.ScaleImage(panelImages.getHeight()));// = new JLabel(new ImageIcon(scaleImage));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LPRStart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

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
		
		JPanel panel = new JPanel();
		panelTools.add(panel);
		panelTools.add(rdbtnSimple);
		panelTools.add(comboGrade);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(new Color(0, 0, 0));
		panelTools.add(toolBar);
		
		
		
		
		JLabel lblTools = new JLabel("TOOL BAR:");
		toolBar.add(lblTools);
		
		JButton buttonZoomIn = new JButton("");
		buttonZoomIn.setIcon(new ImageIcon(LPRStart.class.getResource("/imgResorse/zoom-tool.png")));
		toolBar.add(buttonZoomIn);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		JButton buttonZoomOut = new JButton("");
		buttonZoomOut.setIcon(new ImageIcon(LPRStart.class.getResource("/imgResorse/zoom-out.png")));
		toolBar.add(buttonZoomOut);
		
		JButton buttonLine = new JButton("");
		buttonLine.setIcon(new ImageIcon(LPRStart.class.getResource("/imgResorse/scribble.png")));
		toolBar.add(buttonLine);
		
		JButton buttonElipse = new JButton("");
		buttonElipse.setIcon(new ImageIcon(LPRStart.class.getResource("/imgResorse/ellipse.png")));
		toolBar.add(buttonElipse);
		
		JButton buttonMarker = new JButton("");
		buttonMarker.setIcon(new ImageIcon(LPRStart.class.getResource("/imgResorse/001-highlighter.png")));
		toolBar.add(buttonMarker);
		
		JSeparator separator1 = new JSeparator();
		separator1.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator1);
		
		JButton buttonEraser = new JButton("");
		buttonEraser.setIcon(new ImageIcon(LPRStart.class.getResource("/imgResorse/001-eraser.png")));
		toolBar.add(buttonEraser);
		
		JButton buttonUndo = new JButton("");
		buttonUndo.setIcon(new ImageIcon(LPRStart.class.getResource("/imgResorse/002-undo-arrow.png")));
		toolBar.add(buttonUndo);
		
		JButton buttonRedo = new JButton("");
		buttonRedo.setIcon(new ImageIcon(LPRStart.class.getResource("/imgResorse/001-redo-arrow.png")));
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
		panelImages.setLayout(null);
		
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
						
						pictures.add(new oneLPRImage(img));
						
						JLabel tempJLabel = new JLabel(pictures.get(pictures.size()-1).ScaleImage(300));
						
						tempJLabel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								
								
								panelImages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
								panelImages.removeAll();
								singleImage = new oneLPRImage(img);
								
								JLabelPicture.setIcon(singleImage.ScaleImage(panelImages.getHeight()));// = new JLabel(new ImageIcon(scaleImage));
								panelImages.add(JLabelPicture);
								panelImages.revalidate();
								panelImages.repaint();
							}
						});
						
						
						JLabelPictures.add(tempJLabel);
						panelImages.add(tempJLabel);
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
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				JFileChooser jc = new JFileChooser();
				jc.setDialogTitle("Pleae select wanted picture");
				jc.setMultiSelectionEnabled(false);
				jc.setFileFilter(new FileNameExtensionFilter(".png","PNG"));
				if(jc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					
					singleImage = new oneLPRImage(jc.getSelectedFile());
					JLabelPicture.setIcon(singleImage.ScaleImage(panelImages.getHeight()));// = new JLabel(new ImageIcon(scaleImage));
					panelImages.add(JLabelPicture);
					panelImages.revalidate();
					panelImages.repaint();
				}
			}
		});
		
	
		buttonZoomOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (singleImage.getHeight() > 600) {
					panelImages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					panelImages.removeAll();
					imageSize = singleImage.getHeight();
					JLabelPicture.setIcon(singleImage.ScaleImage(imageSize-20));// = new JLabel(new ImageIcon(scaleImage));
					panelImages.add(JLabelPicture);
					panelImages.revalidate();
					panelImages.repaint();
				}
			}
		});
		
		buttonZoomIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				panelImages.removeAll();
				imageSize = singleImage.getHeight();
				JLabelPicture.setIcon(singleImage.ScaleImage(imageSize+20));// = new JLabel(new ImageIcon(scaleImage));
				panelImages.add(JLabelPicture);
				panelImages.revalidate();
				panelImages.repaint();
			}
		});
		
		/*buttonLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            //Shape line1 = null;
				JOptionPane.showMessageDialog(null, "trying to add component to jlabelpicture..");
	           /* frame.add(new JComponent() {
					Shape line = null;
					//java.awt.geom.Line2D.Double line = new Line2D.Double(100, 100, 200, 200);
					{
					line = new Line2D.Double(100, 100, 200, 200);
					prevPoint = new Point();
		            Point newPoint = new Point();
		            JOptionPane.showMessageDialog(null, "trying to create mouseadapter");
	            
	            	MouseAdapter mouseAdapter = new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							JOptionPane.showMessageDialog(null, "trying to paint...");
							prevPoint = e.getPoint();
		                    System.out.println("Prev Point=" + prevPoint.toString());
		                    panelImages.repaint();
		                }
						@Override
		                public void mouseDragged(MouseEvent e) {
		                    int dx = 0;
		                    int dy = 0;
	
		                    dx = (int) (prevPoint.x - e.getPoint().getX());
		                    dy = (int) (prevPoint.y - e.getPoint().getY());
	
		                    Line2D shape = (Line2D) line;
	
		                    int x1 = (int) (shape.getX1() - dx);
		                    int y1 = (int) (shape.getY1() - dy);
	
		                    int x2 = (int) (shape.getX2() - dx);
		           
		                    int y2 = (int) (shape.getY2() - dy);
	
		                    Point startPoint = new Point(x1, y1);
		                    Point endPoint = new Point(x2, y2);
	
		                    if (shape != null) {
		                        shape.setLine(startPoint, endPoint);
		                        prevPoint = e.getPoint();
		                        panelImages.repaint();
		                    }
						}
						
	            	
		                @Override
		                public void mouseReleased(MouseEvent e) {
		                	panelImages.repaint();
		                }
	            	};	            
		            
	            addMouseListener(mouseAdapter);
	            addMouseMotionListener(mouseAdapter);
	            } 
			@Override	
	        protected void paintComponent(Graphics g) {
	            Graphics2D g2d = (Graphics2D) g;
	            g2d.setPaint(Color.BLUE);
	            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                    RenderingHints.VALUE_ANTIALIAS_ON);
	            if (line != null) {
	                g2d.draw(line);
	            }
			}
	        
	    });*/
	
				
		/*		JPanel p = new JPanel() {
					Point pointStart = null;
			        Point pointEnd   = null;
			        {
			            addMouseListener(new MouseAdapter() {
			                public void mousePressed(MouseEvent e) {
			                    pointStart = e.getPoint();
			                }

			                public void mouseReleased(MouseEvent e) {
			                    pointStart = null;
			                }
			            
			          /*  addMouseMotionListener(new MouseMotionAdapter() {
			                public void mouseMoved(MouseEvent e) {
			                    pointEnd = e.getPoint();
			                }*/

			             /*   public void mouseDragged(MouseEvent e) {
			                    pointEnd = e.getPoint();
			                    repaint();
			                }
			            });
			        }
			        public void paint(Graphics g) {
			            super.paint(g);
			            if (pointStart != null) {
			                g.setColor(Color.RED);
			                g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
			            }
			        }
			    };
			    frame.getContentPane().add(p);	

	  }
				
			
	});*/
	}
}

		
	