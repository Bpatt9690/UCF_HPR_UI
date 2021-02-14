package controllers;

import Interface.ActuatorATimeOutObjectEvent;
import Interface.ActuatorBTimeOutObjectEvent;
import Interface.GSBackground;
import Interface.GSBackgroundController;
import Interface.Orientation_Graphic_ObjectEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class DataController extends Thread implements GSBackground {
	
	GSBackgroundController backgroundController;
	
	public boolean interrupt = false;
	
	public DataController(GSBackgroundController backgroundController) {
		this.backgroundController = backgroundController;
	
	}
	
	public void run() {
	Random rand = new Random();
	int upperbound = 150;
	int u = 20;
	while(interrupt != true) {
		
			//BWP example of data points displaying
		
			int gyrx = rand.nextInt(upperbound);
			int gyry = rand.nextInt(upperbound);
			int gyrz = rand.nextInt(upperbound);
			int accx = rand.nextInt(10+10)-10;
			int accy = rand.nextInt(upperbound);
			int accz = rand.nextInt(upperbound);
			int pressure = rand.nextInt(upperbound);
			int weight = rand.nextInt(upperbound);
			int n2o_temp = rand.nextInt(upperbound);
			
			String compile = gyrx+"|"+gyry+"|"+gyrz+"|"+accx+"|"+accy+"|"+accz+"|";
			
			backgroundController.DataAcquisition(compile);
			
			backgroundController.GYR_X(Integer.toString(gyrx));
			backgroundController.GYR_Y(Integer.toString(gyry));
			backgroundController.GYR_Z(Integer.toString(gyrz));			
			backgroundController.ACC_X(Integer.toString(accx));
			backgroundController.ACC_Y(Integer.toString(accy));
			backgroundController.ACC_Z(Integer.toString(accz));
			backgroundController.PRESSURE(Integer.toString(pressure));
			backgroundController.WEIGHT(Integer.toString(weight));
			backgroundController.N2O_TEMP(Integer.toString(n2o_temp));
			backgroundController.Orientation_Graphic((double)accx);
			

			try {
				Thread.sleep(300);
			} catch (InterruptedException ex) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
	}

	
	public void Interrupt() {
		this.interrupt = true;
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
