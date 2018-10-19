import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Maturaarbeit2 extends Frame implements ActionListener {

	int Bit = 0;
	int stop = 0;
	int halt = 0;
	int f = 0;
	double t = 0;
	int[] shuffle = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
	Button button1;
	Button button2;

	public static void main(String[] args) {

		new Maturaarbeit2();

	}

	public Maturaarbeit2() {

		setLayout(null);

		button1 = new Button("Zeige den Hamiltonkreis");
		button1.addActionListener(this);

		button2 = new Button("Zeige den Isomorphismus");
		button2.addActionListener(this);

		setTitle("Zero-Knowledge Beweisverfahren mit Hamiltonkreisen");
		setBackground(Color.white);
		setSize(1300, 800);
		add(button1);
		add(button2);
		button1.setBounds(550, 250, 200, 50);
		button2.setBounds(550, 400, 200, 50);
		setVisible(true);

	}

	public void paint(Graphics g) {

		if (f == 0) {

			for (int perm = 1; perm < 500; perm++) {

				int a = (int) (Math.random() * 20);
				int b = (int) (Math.random() * 20);

				int Zahl = shuffle[a];
				shuffle[a] = shuffle[b];
				shuffle[b] = Zahl;
			}
			
		}
		f = 1;

		int[][] Matrix = {

				// Zeilen und Spalten von 0 - 9
				// Eckpunkt 0 ist ganz rechts

				//0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19
				{ 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, // 0-4
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0 }, // 1-18
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 2-9
				{ 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1 }, // 3-7
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 4-15
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, // 5-0
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, // 6-19
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0 }, // 7-14
				{ 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, // 8-6
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, // 9-5
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 10-2
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, // 11-8
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, // 12-1
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, // 13-3
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, // 14-16
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, // 15-12
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, // 16-10
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 17-11
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, // 18-13
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, // 19-17
				
				

		};
		g.setColor(Color.black);

		int i = 0;
		int i2 = 0;
		int c = 0;
		int r1 = 200;

		for (int n = 0; n < 20; n++) {

			double t1 = ((Math.PI * 2 / 20) * n);

			double x2 = (r1 * Math.cos(t1));
			double y2 = (r1 * Math.sin(t1));

			int x = (int) Math.round(x2);
			int y = (int) Math.round(y2);

			g.fillOval(300 + x, 350 + y, 10, 10);
			
			Font rechts = new Font ("Arial", 1, 20);
			g.setFont (rechts);
			g.drawString("ORIGINALER GRAPH", 200, 100);
			g.setColor(Color.black);
			
			Font links = new Font ("Arial", 1, 20);
			g.setFont (links);
			g.drawString("ISOMORPHER GRAPH", 900, 100);

			for (int j = 0; j <= 19; j++) {

				if (Matrix[i][j] == 1) {

					double k = ((Math.PI * 2 / 20) * (j));

					double x4 = (r1 * Math.cos(k));
					double y4 = (r1 * Math.sin(k));

					int x3 = (int) Math.round(x4);
					int y3 = (int) Math.round(y4);

					g.drawLine(305 + x, 355 + y, 305 + x3, 355 + y3);

				}
			}
			i++;
		}

		t += 0.0005;
		System.out.println(t);
		if (t > 1) {
			stop = 1;
		}

		if (stop != 1) {
			repaint();
		}

		try {
			if (Bit != 2) {
				t = 0;

			}

			for (int m = 0; m < 20; m++) {

				int r2 = 200;

				double t2 = ((Math.PI * 2 / 20) * shuffle[c]);

				double x6 = (r2 * Math.cos(t2));
				double y6 = (r2 * Math.sin(t2));

				int x5 = (int) Math.round(x6);
				int y5 = (int) Math.round(y6);

				int x10 = (int) (r2 * Math.cos((Math.PI * 2 / 20) * m));
				int y10 = (int) (r2 * Math.sin((Math.PI * 2 / 20) * m));

				int x11 = (int) (x5 * (1 - t) + x10 * t);
				int y11 = (int) (y5 * (1 - t) + y10 * t);
				g.fillOval(1000 + x11, 350 + y11, 10, 10);

				for (int j2 = 0; j2 <= 19; j2++) {

					if (Matrix[i2][j2] == 1) {

						double k2 = ((Math.PI * 2 / 20) * (shuffle[j2]));

						double x8 = (r1 * Math.cos(k2));
						double y8 = (r1 * Math.sin(k2));

						int x7 = (int) Math.round(x8);
						int y7 = (int) Math.round(y8);

						if (Bit == 1) {
							if (i2 == 0) {
								if (j2 == 4) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 1) {
								if (j2 == 18) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 2) {
								if (j2 == 9) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 3) {
								if (j2 == 7) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 4) {
								if (j2 == 15) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 5) {
								if (j2 == 0) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 6) {
								if (j2 == 19) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 7) {
								if (j2 == 14) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 8) {
								if (j2 == 6) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 9) {
								if (j2 == 5) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 10) {
								if (j2 == 2) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 11) {
								if (j2 == 8) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 12) {
								if (j2 == 1) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 13) {
								if (j2 == 3) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 14) {
								if (j2 == 16) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 15) {
								if (j2 == 12) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 16) {
								if (j2 == 10) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 17) {
								if (j2 == 11) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 18) {
								if (j2 == 13) {
									g.setColor(Color.red);
								}
							}
							if (i2 == 19) {
								if (j2 == 17) {
									g.setColor(Color.red);
								}
							}
							
						}

						int x12 = (int) (r2 * Math.cos((Math.PI * 2 / 20) * j2));
						int y12 = (int) (r2 * Math.sin((Math.PI * 2 / 20) * j2));

						int x13 = (int) (x7 * (1 - t) + x12 * t);
						int y13 = (int) (y7 * (1 - t) + y12 * t);

						g.drawLine(1005 + x11, 355 + y11, 1005 + x13, 355 + y13);
						g.setColor(Color.black);

					}
				}
				i2++;
				c++;
			}
			if (Bit == 2) {
				TimeUnit.MILLISECONDS.sleep(2);
			}

		} catch (InterruptedException e) {

			System.out.print("Error");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();

		if (str.equals("Zeige den Hamiltonkreis")) {
			if (Bit != 2) {
				Bit = 1;
				repaint();
			}

		}

		if (str.equals("Zeige den Isomorphismus")) {
			if (Bit != 1) {
				if (halt !=1) {
				Bit = 2;
				halt = 1;
				repaint();
			}
			}
		}

	}
}
