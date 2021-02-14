package controllers;

import Interface.ActuatorATimeOutObjectEvent;
import Interface.ActuatorBTimeOutObjectEvent;
import Interface.GSBackground;
import Interface.GSBackgroundController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ButtonController implements GSBackground {
	
	//handle sending data to GSE
	
	GSBackgroundController backgroundController;

	public ButtonController(GSBackgroundController backgroundController) {
		this.backgroundController = backgroundController;
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
	public void DataAcquisitionObjectEvent(Interface.DataAcquisitionObjectEvent e,String data) {
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
