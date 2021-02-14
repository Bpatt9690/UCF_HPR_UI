package controllers;

import Interface.ActuatorATimeOutObjectEvent;
import javafx.scene.canvas.*;
import Interface.ActuatorBTimeOutObjectEvent;
import Interface.GSBackground;
import Interface.GSBackgroundController;
import Interface.Orientation_Graphic_ObjectEvent;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;


import java.util.*;

public class UIController implements GSBackground {

	GSBackgroundController backgroundControl;
	DataController dataController;
	GSE_Link GSE;
	
	@FXML private Label ACTA_TIMEOUT;
	@FXML private Label ACTB_TIMEOUT;
	@FXML private Label GYRX_PITCH;
	@FXML private Label GYRY_YAW;
	@FXML private Label GYRZ_ROLL;
	@FXML private Label ACC_X;
	@FXML private Label ACC_Y;
	@FXML private Label ACC_Z;
	@FXML private Label PRESSURE;
	@FXML private Label WEIGHT;
	@FXML private Label N2O_TEMP;
	
	@FXML private Button ACTUATOR_A;
	@FXML private Button ACTUATOR_B;
	@FXML private Button START_LINK;
	@FXML private Button CAMERAS;
	@FXML private Button IGNITION_BUTTON;
	
	@FXML private Pane ORIENTATION_PANE;
	
	@FXML private TextField CONNECTION_PORT_FIELD;
	@FXML private ListView RAW_TELEMETRY_LIST;
	@FXML private Cylinder cyl;
	@FXML private Rectangle rect;
		
	private int ACT_A_STATUS = 0;
	private int ACT_B_STATUS = 0;
	
	private boolean GSE_LINK_STATUS = false;

	@FXML
	private void act_a() {
		
	
		if(GSE_LINK_STATUS == true) {
		
			if(ACT_A_STATUS == 0) {
				ACTUATOR_A.setText("OPENED");
				ACT_A_STATUS = 1;
				
				try {
				GSE.GSE_Information("ao\r\n");
				}
				catch(NullPointerException es) {
					System.out.println(es);
				}
			}
			
			else if(ACT_A_STATUS == 1) {
				ACTUATOR_A.setText("CLOSED");
				ACT_A_STATUS = 0;
				GSE.GSE_Information("ac\r\n");
			}
		
	
			Timer myTimer = new Timer();	
			myTimer.schedule(new TimerTask() {
				int i= 0;
				@Override
				public void run() {
					Platform.runLater(()->{;
					backgroundControl.ActuatorATimeOut(i);	
					i++;
					
					if(i > 15) {
						i = 0;
						myTimer.purge();
						myTimer.cancel();
						
					}
				});
				}
			},0,1000);
			
		}
		
		else {
			System.out.println("Inform UI");
		}
		
		
	}
	
	
	@FXML
	private void act_b() {
		
		if(GSE_LINK_STATUS == true) {
		
			if(ACT_B_STATUS == 0) {
				ACTUATOR_B.setText("OPENED");
				ACT_B_STATUS = 1;
				GSE.GSE_Information("bo\r\n");
			}
			
			else if(ACT_B_STATUS == 1) {
				ACTUATOR_B.setText("CLOSED");
				ACT_B_STATUS = 0;
				GSE.GSE_Information("bc\r\n");
			}
		
	
			Timer myTimer = new Timer();	
			myTimer.schedule(new TimerTask() {
				int i= 0;
				@Override
				public void run() {
					Platform.runLater(()->{;
					backgroundControl.ActuatorBTimeOut(i);	
					i++;
					
					if(i > 15) {
						i = 0;
						myTimer.purge();
						myTimer.cancel();
						
					}
				});
				}
			},0,1000);
		}
		
		else {
			System.out.println("Inform UI");
		}
		
	}
	
	public void GSE_Link() throws InterruptedException
	{
			
		String[] SOCKET_PARAMS = null; 
		String IP_ADDRESS = null;
		String GSE_Information = CONNECTION_PORT_FIELD.getText();
		
		dataController = new DataController(this.backgroundControl);
		backgroundControl.addListener(dataController);
		
		int PORT = 0;
		
		if(GSE_Information.isBlank() || GSE_Information.isEmpty()) {
			//inform UI
		}
		
		else
		{
	
			if(GSE_Information.contains(";")) {
			
				SOCKET_PARAMS = GSE_Information.split(";",2);
				
				IP_ADDRESS = SOCKET_PARAMS[0];
				
				PORT = Integer.parseInt(SOCKET_PARAMS[1]);
				
				System.out.println(IP_ADDRESS);
				System.out.println(PORT);
				
				this.GSE = new GSE_Link(IP_ADDRESS,PORT,backgroundControl,this);
				backgroundControl.addListener(GSE);
				
				if(GSE_LINK_STATUS == true)
					Enable_UI();
			
			}
			
			else{
				//inform UI
			}
			
		}
				
	}
	
	
	public void Close_GSE_Link() {
		this.GSE.Close_Link();
		this.dataController.Interrupt();
	}
	

	//Enabling UI Button Functionality that relies on Socket connection
	//Enables rocket orientation graphic
	public void Enable_UI() {
		
		//Enabling button functionality now socket connection established
		ACTUATOR_A.setDisable(false);
		ACTUATOR_B.setDisable(false);
		CAMERAS.setDisable(false);
		
		
		//Adding rocket graphic to pane
		Image img = new Image("img.jpg");
		rect.setFill(new ImagePattern(img));
		
		//intiating data acquistion process
		dataController.start();
		
	}

	@Override
	public void ActuatorATimeOutEvent(ActuatorATimeOutObjectEvent e, int time) {
		// TODO Auto-generated method stub
	
			if(time != 15) {
				ACTUATOR_A.setDisable(true);
				ACTUATOR_B.setDisable(true);
			}
			
			else if(time == 15) {
				ACTUATOR_A.setDisable(false);
				ACTUATOR_B.setDisable(false);
			}
		
		
			ACTA_TIMEOUT.setText(Integer.toString(time)+"/s");
			
	}
	
	public void setBackGroundController(GSBackgroundController backgroundControl) {
		this.backgroundControl = backgroundControl;
	}


	@Override
	public void ActuatorBTimeOutEvent(ActuatorBTimeOutObjectEvent e, int time) {
		// TODO Auto-generated method stub
		if(time != 15) {
			ACTUATOR_B.setDisable(true);
			ACTUATOR_A.setDisable(true);
		}
		
		else if(time == 15) {
			ACTUATOR_B.setDisable(false);
			ACTUATOR_A.setDisable(false);
		}
	
		ACTB_TIMEOUT.setText(Integer.toString(time)+"/s");
		
	}
	
	
	public void setDataController(DataController dataController) {
		this.dataController = dataController;
	}


	@Override
	public void DataAcquisitionObjectEvent(Interface.DataAcquisitionObjectEvent e, String data) {
				
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 RAW_TELEMETRY_LIST.getItems().add(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
	}


	@Override
	public void GYR_X_ObjectEvent(Interface.GYR_X_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 GYRX_PITCH.setText(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
		
	}


	@Override
	public void GYR_Y_ObjectEvent(Interface.GYR_Y_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
	
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 GYRY_YAW.setText(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
	}


	@Override
	public void GYR_Z_ObjectEvent(Interface.GYR_Z_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
	
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 GYRZ_ROLL.setText(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
	}


	@Override
	public void ACC_X_ObjectEvent(Interface.ACC_X_ObjectEvent e, String data) {
		// TODO Auto-generated method stub	
		Task<Void> task = new Task<Void>() {
		 @Override protected Void call() throws Exception {
			 Platform.runLater(new Runnable() {
				 @Override public void run() {
					 ACC_X.setText(data);
				 }
				 });
			return null;
		
		 }
	};
	
	task.run();
		
	}


	@Override
	public void ACC_Y_ObjectEvent(Interface.ACC_Y_ObjectEvent e, String data) {
		// TODO Auto-generated method stub	
		Task<Void> task = new Task<Void>() {
		 @Override protected Void call() throws Exception {
			 Platform.runLater(new Runnable() {
				 @Override public void run() {
					 ACC_Y.setText(data);
				 }
				 });
			return null;
		
		 }
	};
	
	task.run();
		
	}


	@Override
	public void ACC_Z_ObjectEvent(Interface.ACC_Z_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 ACC_Z.setText(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
	}


	@Override
	public void PRESSURE_ObjectEvent(Interface.PRESSURE_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 PRESSURE.setText(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
		
	}


	@Override
	public void WEIGHT_ObjectEvent(Interface.WEIGHT_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 WEIGHT.setText(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
		
	}


	@Override
	public void N2O_TEMP_ObjectEvent(Interface.N2O_TEMP_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 N2O_TEMP.setText(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
		
	}


	@Override
	public void Orientation_Graphic_ObjectEvent(Interface.Orientation_Graphic_ObjectEvent e, double data) {
		// TODO Auto-generated method stub
		Task<Void> task = new Task<Void>() {
			 @Override protected Void call() throws Exception {
				 Platform.runLater(new Runnable() {
					 @Override public void run() {
						 rect.setRotate(data);
					 }
					 });
				return null;
			
			 }
		};
		
		task.run();
		
	}

	
	
	@SuppressWarnings("deprecation")
	public void GSE_LINK_STATUS(boolean bool) {
		this.GSE_LINK_STATUS = bool;
		//this.dataController.stop();
	}
	

}
