import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ZoomIn {

	private JFrame frame;
	private JLabel JLabelPicture;
	private ImageIcon image;
	private Image oneImage;

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
		
		JButton buttonZoomIn = new JButton("");
		buttonZoomIn.setIcon(new ImageIcon(ZoomIn.class.getResource("/imgResorse/zoom-tool.png")));
		toolBar.add(buttonZoomIn);
		
		JPanel panelImages = new JPanel();
		scrollPane.setViewportView(panelImages);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOpen = new JMenu("Open");
		menuBar.add(mnOpen);
		
		JMenuItem mntmFile = new JMenuItem("File");
		mntmFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelImages.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				panelImages.removeAll();
				JFileChooser jc = new JFileChooser();
				jc.setDialogTitle("Pleae select wanted pictures");
				jc.setMultiSelectionEnabled(false);
				jc.setFileFilter(new FileNameExtensionFilter(".png","PNG"));
				if(jc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					File picture = jc.getSelectedFile();
					image = new ImageIcon(picture.getAbsolutePath());
					int imageActualHeight = image.getIconHeight();
					int imageActualWidth = image.getIconWidth();
					int imageProportion = imageActualWidth/imageActualHeight;
					int width = panelImages.getWidth()*imageProportion;
					int height = panelImages.getHeight();
					JLabelPicture = new JLabel();
					
					oneImage = image.getImage().getScaledInstance(int width = panelImages.getWidth()*imageProportion,panelImages.getHeight(), Image.SCALE_DEFAULT);
					JLabelPicture.setIcon(new ImageIcon(oneImage));// = new JLabel(new ImageIcon(scaleImage));
					panelImages.add(JLabelPicture);
					panelImages.revalidate();
					panelImages.repaint();
				}
			}
			
		});
		mnOpen.add(mntmFile);
	}

}
