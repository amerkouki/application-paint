package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.LineBorder;

import paint.PaintPoly;
import paint.Paint_rectangleCercle;


public class frame extends JFrame {

	public static MouseListener mouseListener;
	public static MouseMotionAdapter mouseMotionAdapter;
	public static String forms,type="draw"; 
	public static JPanel panellblColor;
	private JPanel contentPane,panelForms,panelNbrPoint,panelColor,panelCol;
	panelGraphic panelDessin;

	private JPanel[][][] tablColor=new JPanel[7][7][6];

	public static JTextField nbrPoint;
	JLabel lblnbr,retour;
	JButton btnClose;
	JPanel panelSavgard, panelPaint,panelCercle,panelRectangle,panelArc,panelLine,panelRoundRect,
	panelPolygone,panelPolyline,paneldrawType,panelfillType,panelRetour;
	JLabel Savegard,Paint,Cercle,Rectangle,Arc,Line,RoundRect,
	Polygone,Polyline,drawType,fillType,lblColor,lblClose;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
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
	public frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);


		panelDessin=new panelGraphic();

		panelForms=new JPanel();
		panelForms.setBorder(new LineBorder(Color.BLACK));
		panelColor=new JPanel();
		panelColor.setBorder(new LineBorder(Color.BLACK));
		panelDessin.setBorder(new LineBorder(Color.BLACK));

		contentPane.add("Center",panelDessin);
		contentPane.add("North",panelForms);


		panelDessin.setLayout(null);



		panelColor.setBounds(1,1,300,300);
		panelDessin.add(panelColor);

		
		
		drawType=new JLabel("");
		fillType=new JLabel("");
		lblColor=new JLabel("");
		lblClose=new JLabel("X");

		panelColor.setLayout(null);
		lblClose.setBounds(panelColor.getWidth()-30,2,20,20);
		panelColor.add(lblClose);
		panelColor.setVisible(false);
		
		panelCol=new JPanel();
		panelCol.setLayout(new GridLayout(16,15));
		//panelCol.setBackground(Color.red);
		panelCol.setBounds(1,20,panelColor.getWidth()-2,panelColor.getHeight()-25);
		panelColor.add(panelCol);
		
		setTablColor(tablColor, panelCol);
		
	
		
		panelNbrPoint=new JPanel();
		panelNbrPoint.setBounds(1,1,200,90);
		panelNbrPoint.setBorder(new LineBorder(Color.BLACK));
		panelNbrPoint.setBackground(Color.white);
		panelNbrPoint.setLayout(new GridLayout(3,3));
		panelDessin.add(panelNbrPoint);

		Savegard=new JLabel("");
		Savegard.setBorder(new LineBorder(Color.BLACK));

		Paint=new JLabel("");
		Cercle=new JLabel("");
		Rectangle=new JLabel("");
		Arc=new JLabel("");
		RoundRect=new JLabel("");
		Polygone=new JLabel("");
		Polyline=new JLabel("");
		Line=new JLabel("");
		retour=new JLabel("");
		//panelForms.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		setIcon(Paint,"paint");
		setIcon(Cercle,"cercle");
		setIcon(Rectangle,"rectangle");
		setIcon(Arc,"arc");
		setIcon(RoundRect,"roundRect");
		setIcon(Polygone,"polygon");
		setIcon(Polyline,"polyline");
		setIcon(Line,"line");

		setIcon(retour,"retour");
		setIcon(lblColor,"Color");
		setIcon(fillType,"fill");
		setIcon(drawType,"draw2");
		setIcon(Savegard, "save");

		panelSavgard=new JPanel();
		panelSavgard.add(Savegard);
		panelSavgard.setBackground(Color.white);
		panelPaint=new JPanel();
		panelPaint.add(Paint);
		panelCercle=new JPanel();
		panelCercle.add(Cercle);
		panelRectangle=new JPanel();
		panelRectangle.add(Rectangle);
		panelArc=new JPanel();
		panelArc.add(Arc);
		panelLine=new JPanel();
		panelLine.add(Line);
		panelRoundRect=new JPanel();
		panelRoundRect.add(RoundRect);
		panelPolygone=new JPanel();
		panelPolygone.add(Polygone);
		panelPolyline=new JPanel();
		panelPolyline.add(Polyline);


		panelLine.setBackground(Color.white);
		panelCercle.setBackground(Color.white);
		panelRectangle.setBackground(Color.white);
		panelArc.setBackground(Color.white);
		panelRoundRect.setBackground(Color.white);
		panelPolygone.setBackground(Color.white);
		panelPolyline.setBackground(Color.white);
		panelPaint.setBackground(Color.white);


		paneldrawType=new JPanel();

		paneldrawType.add(drawType);
		paneldrawType.setBackground(Color.lightGray);
		panelfillType=new JPanel();
		panelfillType.add(fillType);
		panellblColor=new JPanel();
		panellblColor.add(lblColor);
		panellblColor.setBackground(Color.black);
		panelRetour=new JPanel();
		panelRetour.add(retour);
		panelRetour.setBackground(Color.white);

		panelForms.add(panelSavgard);
		panelForms.add(panelPaint);
		panelForms.add(panelCercle);
		panelForms.add(panelRectangle);
		panelForms.add(panelArc);
		panelForms.add(panelRoundRect);
		panelForms.add(panelPolygone);
		panelForms.add(panelPolyline);
		panelForms.add(panelLine);
		panelForms.add(new JPanel());
		panelForms.add(panelRetour);

		panelForms.add(panellblColor);
		panelForms.add(panelfillType);
		panelForms.add(paneldrawType);


		nbrPoint=new JTextField("4");
		lblnbr=new JLabel("nombre des point");
		btnClose=new JButton("Close");
		btnClose.setSize(new Dimension(10,10));

		Savegard.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					saveScreenShot(panelDessin,"test.png");
					//System.out.println("saved ************** ");
					panelSavgard.setBackground(Color.lightGray);
				} catch (IOException e) {
					System.out.println("erreur ************** ");
				}
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				panelSavgard.setBackground(Color.white);
			}
			
		});


		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelNbrPoint.setVisible(false);
			}
		});
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelColor.setVisible(false);
			}
		});

		panelNbrPoint.add(lblnbr);
		panelNbrPoint.add(nbrPoint);
		panelNbrPoint.add(btnClose);
		panelNbrPoint.setVisible(false);


		//nbrPoint.setVisible(false);

		Paint.setBorder(new LineBorder(Color.BLACK));
		Cercle.setBorder(new LineBorder(Color.BLACK));
		Rectangle.setBorder(new LineBorder(Color.BLACK));
		Arc.setBorder(new LineBorder(Color.BLACK));
		RoundRect.setBorder(new LineBorder(Color.BLACK));
		Polygone.setBorder(new LineBorder(Color.BLACK));
		Polyline.setBorder(new LineBorder(Color.BLACK));
		Line.setBorder(new LineBorder(Color.BLACK));
		fillType.setBorder(new LineBorder(Color.BLACK));
		drawType.setBorder(new LineBorder(Color.BLACK));
		lblColor.setBorder(new LineBorder(Color.BLACK));
		retour.setBorder(new LineBorder(Color.BLACK));




		Rectangle.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDessin.removeMouseListener(mouseListener);
				panelDessin.removeMouseMotionListener(mouseMotionAdapter);

				forms="rectangle";
				Paint_rectangleCercle r=new Paint_rectangleCercle(panelDessin);
				r.init();	
				panelRectangle.setBackground(Color.lightGray);
				panelCercle.setBackground(Color.white);
				panelPaint.setBackground(Color.white);
				panelArc.setBackground(Color.white);
				panelRoundRect.setBackground(Color.white);
				panelPolygone.setBackground(Color.white);
				panelPolyline.setBackground(Color.white);
				panelLine.setBackground(Color.white);

			}
		});

		Line.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDessin.removeMouseListener(mouseListener);
				panelDessin.removeMouseMotionListener(mouseMotionAdapter);

				forms="line";
				Paint_rectangleCercle r=new Paint_rectangleCercle(panelDessin);
				r.init();
				panelCercle.setBackground(Color.white);
				panelLine.setBackground(Color.lightGray);
				panelRectangle.setBackground(Color.white);
				panelArc.setBackground(Color.white);
				panelRoundRect.setBackground(Color.white);
				panelPolygone.setBackground(Color.white);
				panelPolyline.setBackground(Color.white);
				panelPaint.setBackground(Color.white);
			}

		});

		Polyline.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDessin.removeMouseListener(mouseListener);
				panelDessin.removeMouseMotionListener(mouseMotionAdapter);
				panelNbrPoint.setVisible(true);
				panelColor.setVisible(false);
				forms="polyline";
				PaintPoly p=new PaintPoly(panelDessin);
				p.init();
				panelCercle.setBackground(Color.white);
				panelPolyline.setBackground(Color.lightGray);
				panelRectangle.setBackground(Color.white);
				panelArc.setBackground(Color.white);
				panelRoundRect.setBackground(Color.white);
				panelPolygone.setBackground(Color.white);
				panelPaint.setBackground(Color.white);
				panelLine.setBackground(Color.white);
			}
		});

		Polygone.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDessin.removeMouseListener(mouseListener);
				panelDessin.removeMouseMotionListener(mouseMotionAdapter);
				panelNbrPoint.setVisible(true);
				panelColor.setVisible(false);
				forms="polygone";
				PaintPoly p=new PaintPoly(panelDessin);
				p.init();
				panelCercle.setBackground(Color.white);
				panelPolygone.setBackground(Color.lightGray);
				panelRectangle.setBackground(Color.white);
				panelArc.setBackground(Color.white);
				panelRoundRect.setBackground(Color.white);
				panelPaint.setBackground(Color.white);
				panelPolyline.setBackground(Color.white);
				panelLine.setBackground(Color.white);
			}

		});

		RoundRect.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDessin.removeMouseListener(mouseListener);
				panelDessin.removeMouseMotionListener(mouseMotionAdapter);

				forms="roundRect";
				Paint_rectangleCercle r=new Paint_rectangleCercle(panelDessin);
				r.init();
				panelCercle.setBackground(Color.white);
				panelRoundRect.setBackground(Color.lightGray);
				panelRectangle.setBackground(Color.white);
				panelArc.setBackground(Color.white);
				panelPaint.setBackground(Color.white);
				panelPolygone.setBackground(Color.white);
				panelPolyline.setBackground(Color.white);
				panelLine.setBackground(Color.white);
			}

		});
		Arc.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDessin.removeMouseListener(mouseListener);
				panelDessin.removeMouseMotionListener(mouseMotionAdapter);

				forms="arc";
				Paint_rectangleCercle r=new Paint_rectangleCercle(panelDessin);
				r.init();	
				panelCercle.setBackground(Color.white);
				panelArc.setBackground(Color.lightGray);
				panelRectangle.setBackground(Color.white);
				panelPaint.setBackground(Color.white);
				panelRoundRect.setBackground(Color.white);
				panelPolygone.setBackground(Color.white);
				panelPolyline.setBackground(Color.white);
				panelLine.setBackground(Color.white);

			}

		});
		Cercle.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDessin.removeMouseListener(mouseListener);
				panelDessin.removeMouseMotionListener(mouseMotionAdapter);

				forms="cercle";
				Paint_rectangleCercle r=new Paint_rectangleCercle(panelDessin);
				r.init();
				panelPaint.setBackground(Color.white);
				panelCercle.setBackground(Color.lightGray);
				panelRectangle.setBackground(Color.white);
				panelArc.setBackground(Color.white);
				panelRoundRect.setBackground(Color.white);
				panelPolygone.setBackground(Color.white);
				panelPolyline.setBackground(Color.white);
				panelLine.setBackground(Color.white);
			}
		});

		Paint.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				panelDessin.removeMouseListener(mouseListener);
				panelDessin.removeMouseMotionListener(mouseMotionAdapter);
				Paint p=new Paint(panelDessin);
				p.init();	

				panelPaint.setBackground(Color.lightGray);
				panelCercle.setBackground(Color.white);
				panelRectangle.setBackground(Color.white);
				panelArc.setBackground(Color.white);
				panelRoundRect.setBackground(Color.white);
				panelPolygone.setBackground(Color.white);
				panelPolyline.setBackground(Color.white);
				panelLine.setBackground(Color.white);

			}

		});


		drawType.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				type="draw";
				panelfillType.setBackground(Color.white);
				paneldrawType.setBackground(Color.lightGray);
			}		

		});
		fillType.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				type="fill";
				paneldrawType.setBackground(Color.white);
				panelfillType.setBackground(Color.lightGray);
			}


		});
		lblColor.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				panelColor.setVisible(true);
				panelNbrPoint.setVisible(false);
				//panellblColor.setBackground(Color.lightGray);
			}


			@Override
			public void mouseReleased(MouseEvent e) {
				//panellblColor.setBackground(Color.white);
			}

		});
		retour.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				panelDessin.undo();
				panelRetour.setBackground(Color.lightGray);
			}


			@Override
			public void mouseReleased(MouseEvent e) {
				panelRetour.setBackground(Color.white);
			}
		});

	}

	public void setIcon(JLabel lb,String im) {
		ImageIcon logoImageM=new ImageIcon(frame.class.getResource("/images/"+im+".png"));
		Image imageO=logoImageM.getImage();
		Image tmp_ImageO=imageO.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		logoImageM=new ImageIcon(tmp_ImageO);
		lb.setIcon(logoImageM);
	}


	public BufferedImage screenShot(Component component) {
		BufferedImage image=new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);

		component.paint(image.getGraphics());
		return image;
	}
	public void saveScreenShot(Component component,String filename) throws IOException {
		BufferedImage im=screenShot(component);
		ImageIO.write(im, "png", new File(filename));
	}


	public void setTablColor(JPanel[][][] col,JPanel pan) {
		boolean valtes=false;
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				for(int k=0;k<6;k++) {
				col[i][j][k]=new JPanel();
				col[i][j][k].setBorder(new LineBorder(Color.BLACK));
				
				
				col[i][j][k].setBackground(new Color(k*42,j*36,i*36));
				col[i][j][k].addMouseListener(new AdapterColor(col[i][j][k]));
				pan.add(col[i][j][k]);
				}
			}
		}
	}
}
