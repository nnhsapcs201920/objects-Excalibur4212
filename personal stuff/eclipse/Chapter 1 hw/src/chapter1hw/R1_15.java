package chapter1hw;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class R1_15 {

	private JFrame frmSurfaceareacalc;
	private JTextField houseW;
	private JTextField houseL;
	private JTextField houseH;
	private JTextField winA;
	private JLabel lblWindowNum;
	private JTextField winL;
	private JLabel lblWindowLength;
	private JTextField winH;
	private JLabel lblWindowHeight;
	private JTextField doorA;
	private JLabel lblDoorAmount;
	private JTextField doorL;
	private JLabel lblDoorLength;
	private JTextField doorH;
	private JLabel lblDoorHeight;
	private JTextField result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					R1_15 window = new R1_15();
					window.frmSurfaceareacalc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public R1_15() {
		initialize();
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSurfaceareacalc = new JFrame();
		frmSurfaceareacalc.setTitle("SurfaceAreaCalc");
		frmSurfaceareacalc.setBounds(100, 100, 450, 300);
		frmSurfaceareacalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSurfaceareacalc.getContentPane().setLayout(null);
		
		houseW = new JTextField();
		houseW.setBounds(10, 25, 96, 27);
		frmSurfaceareacalc.getContentPane().add(houseW);
		houseW.setColumns(10);
		
		JLabel lblHouseWidth = new JLabel("House Width");
		lblHouseWidth.setBounds(10, 11, 78, 14);
		frmSurfaceareacalc.getContentPane().add(lblHouseWidth);
		
		houseL = new JTextField();
		houseL.setColumns(10);
		houseL.setBounds(10, 83, 96, 27);
		frmSurfaceareacalc.getContentPane().add(houseL);
		
		JLabel lblHouseLength = new JLabel("House Length");
		lblHouseLength.setBounds(10, 69, 78, 14);
		frmSurfaceareacalc.getContentPane().add(lblHouseLength);
		
		houseH = new JTextField();
		houseH.setColumns(10);
		houseH.setBounds(10, 137, 96, 27);
		frmSurfaceareacalc.getContentPane().add(houseH);
		
		JLabel lblHouseHeight = new JLabel("House Height");
		lblHouseHeight.setBounds(10, 123, 78, 14);
		frmSurfaceareacalc.getContentPane().add(lblHouseHeight);
		
		winA = new JTextField();
		winA.setColumns(10);
		winA.setBounds(136, 25, 96, 27);
		frmSurfaceareacalc.getContentPane().add(winA);
		
		lblWindowNum = new JLabel("Window Amount");
		lblWindowNum.setBounds(136, 11, 96, 14);
		frmSurfaceareacalc.getContentPane().add(lblWindowNum);
		
		winL = new JTextField();
		winL.setColumns(10);
		winL.setBounds(136, 83, 96, 27);
		frmSurfaceareacalc.getContentPane().add(winL);
		
		lblWindowLength = new JLabel("Window Length");
		lblWindowLength.setBounds(136, 69, 96, 14);
		frmSurfaceareacalc.getContentPane().add(lblWindowLength);
		
		winH = new JTextField();
		winH.setColumns(10);
		winH.setBounds(136, 137, 96, 27);
		frmSurfaceareacalc.getContentPane().add(winH);
		
		lblWindowHeight = new JLabel("Window Height");
		lblWindowHeight.setBounds(136, 123, 96, 14);
		frmSurfaceareacalc.getContentPane().add(lblWindowHeight);
		
		doorA = new JTextField();
		doorA.setColumns(10);
		doorA.setBounds(271, 25, 96, 27);
		frmSurfaceareacalc.getContentPane().add(doorA);
		
		lblDoorAmount = new JLabel("Door Amount");
		lblDoorAmount.setBounds(271, 11, 96, 14);
		frmSurfaceareacalc.getContentPane().add(lblDoorAmount);
		
		doorL = new JTextField();
		doorL.setColumns(10);
		doorL.setBounds(271, 83, 96, 27);
		frmSurfaceareacalc.getContentPane().add(doorL);
		
		lblDoorLength = new JLabel("Door Length");
		lblDoorLength.setBounds(271, 69, 96, 14);
		frmSurfaceareacalc.getContentPane().add(lblDoorLength);
		
		doorH = new JTextField();
		doorH.setColumns(10);
		doorH.setBounds(271, 137, 96, 27);
		frmSurfaceareacalc.getContentPane().add(doorH);
		
		lblDoorHeight = new JLabel("Door Height");
		lblDoorHeight.setBounds(271, 123, 96, 14);
		frmSurfaceareacalc.getContentPane().add(lblDoorHeight);
		
		JButton btnNewButton = new JButton("Compute");
		btnNewButton.setBounds(143, 175, 89, 23);
		frmSurfaceareacalc.getContentPane().add(btnNewButton);
		class AddMouseClickListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				try {
					double finalresult = 0;
					finalresult = ((Double.parseDouble(houseW.getText())*Double.parseDouble(houseH.getText())*2+Double.parseDouble(houseL.getText())*
							Double.parseDouble(houseH.getText())*2)-((Double.parseDouble(winA.getText())*(Double.parseDouble(winH.getText())*
									Double.parseDouble(winL.getText()))))-((Double.parseDouble(doorA.getText())*(Double.parseDouble(doorH.getText())*
											Double.parseDouble(doorL.getText())))));
					result.setText(""+finalresult);
				} catch(Exception e) {
					result.setText("Something Went Wrong. Please Try Again Later.");
				}
			}
		}
		ActionListener listener = new AddMouseClickListener();
		btnNewButton.addActionListener(listener);
		
		result = new JTextField();
		result.setBounds(10, 230, 357, 20);
		frmSurfaceareacalc.getContentPane().add(result);
		result.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 209, 48, 14);
		frmSurfaceareacalc.getContentPane().add(lblNewLabel);
	}
}
