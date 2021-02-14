package controllers;

import Interface.ActuatorATimeOutObjectEvent;
import Interface.ActuatorBTimeOutObjectEvent;
import Interface.GSBackground;
import Interface.GSBackgroundController;

import java.net.*;
import java.io.*;


import java.util.Base64;

public class GSE_Link extends Thread implements GSBackground {

	private String GSE_IP;
	private int GSE_Port;
	GSBackgroundController GSBackground;
	PrintWriter out;
	Socket socketDL = null;
	DataInputStream input = null;
	UIController uiControl = null;
	

	//Passing IP, Port, and reference to Background controller from UI
	//Need DL Port and UL port
	public GSE_Link(String GSE_IP,int Port, GSBackgroundController GSBackground,UIController uiControl) {
		
		this.GSE_IP = GSE_IP;
		this.GSE_Port = Port;
		this.GSBackground = GSBackground;
		this.uiControl = uiControl;
		
	
		
		try {
			this.socketDL = new Socket(GSE_IP,Port);
			this.input = new DataInputStream(System.in);
			uiControl.GSE_LINK_STATUS(true);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			uiControl.GSE_LINK_STATUS(false);
			System.out.println(e);
			e.printStackTrace();
		}
				
	}
	

	public void GSE_Information(String command) {
		try {
			this.out = new PrintWriter(this.socketDL.getOutputStream(),true);
			out.print(command);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	public void Close_Link() {
		try {
			this.socketDL.close();
			uiControl.GSE_LINK_STATUS(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Inform UI");
		}
	}
	
	
	
	
	
	
	
	public void GSE_Client_Connection(String command) {
		
	}
	
	@Override
	public void ActuatorATimeOutEvent(ActuatorATimeOutObjectEvent e, int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ActuatorBTimeOutEvent(ActuatorBTimeOutObjectEvent e, int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DataAcquisitionObjectEvent(Interface.DataAcquisitionObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GYR_X_ObjectEvent(Interface.GYR_X_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GYR_Y_ObjectEvent(Interface.GYR_Y_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GYR_Z_ObjectEvent(Interface.GYR_Z_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ACC_X_ObjectEvent(Interface.ACC_X_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ACC_Y_ObjectEvent(Interface.ACC_Y_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ACC_Z_ObjectEvent(Interface.ACC_Z_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PRESSURE_ObjectEvent(Interface.PRESSURE_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void WEIGHT_ObjectEvent(Interface.WEIGHT_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void N2O_TEMP_ObjectEvent(Interface.N2O_TEMP_ObjectEvent e, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Orientation_Graphic_ObjectEvent(Interface.Orientation_Graphic_ObjectEvent e, double data) {
		// TODO Auto-generated method stub
		
	}
	
}
