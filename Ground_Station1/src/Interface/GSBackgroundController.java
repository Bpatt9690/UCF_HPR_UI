package Interface;

import java.util.Vector;

public class GSBackgroundController {

private Vector<GSBackground> listener = new Vector<GSBackground>();
	
	public void addListener(GSBackground listenerObject) {
		listener.addElement(listenerObject);
	}
	
	public void removeListener(GSBackground listenerObject) {
		listener.removeElement(listenerObject);
	}
	
	@SuppressWarnings("unchecked")
	public void ActuatorATimeOut(int time) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			ActuatorATimeOutObjectEvent newEvent = new ActuatorATimeOutObjectEvent(this);
			listenerCopy.ActuatorATimeOutEvent(newEvent, time);
		}
		
	}
	
	public void ActuatorBTimeOut(int time) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			ActuatorBTimeOutObjectEvent newEvent = new ActuatorBTimeOutObjectEvent(this);
			listenerCopy.ActuatorBTimeOutEvent(newEvent, time);
		}
		
	}
	

	public void DataAcquisition(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			DataAcquisitionObjectEvent newEvent = new DataAcquisitionObjectEvent(this);
			listenerCopy.DataAcquisitionObjectEvent(newEvent, data);
		}
		
	}
	
	public void GYR_X(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			GYR_X_ObjectEvent newEvent = new GYR_X_ObjectEvent(this);
			listenerCopy.GYR_X_ObjectEvent(newEvent, data);
		}
		
	}
	
	
	public void GYR_Y(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			GYR_Y_ObjectEvent newEvent = new GYR_Y_ObjectEvent(this);
			listenerCopy.GYR_Y_ObjectEvent(newEvent, data);
		}
		
	}
	
	
	
	public void GYR_Z(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			GYR_Z_ObjectEvent newEvent = new GYR_Z_ObjectEvent(this);
			listenerCopy.GYR_Z_ObjectEvent(newEvent, data);
		}
		
	}
	
	public void ACC_X(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			ACC_X_ObjectEvent newEvent = new ACC_X_ObjectEvent(this);
			listenerCopy.ACC_X_ObjectEvent(newEvent, data);
		}
		
	}
	
	public void ACC_Y(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			ACC_Y_ObjectEvent newEvent = new ACC_Y_ObjectEvent(this);
			listenerCopy.ACC_Y_ObjectEvent(newEvent, data);
		}
		
	}
	
	
	public void ACC_Z(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			ACC_Z_ObjectEvent newEvent = new ACC_Z_ObjectEvent(this);
			listenerCopy.ACC_Z_ObjectEvent(newEvent, data);
		}
		
	}
	
	public void PRESSURE(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			PRESSURE_ObjectEvent newEvent = new PRESSURE_ObjectEvent(this);
			listenerCopy.PRESSURE_ObjectEvent(newEvent, data);
		}
		
	}
	
	public void WEIGHT(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			WEIGHT_ObjectEvent newEvent = new WEIGHT_ObjectEvent(this);
			listenerCopy.WEIGHT_ObjectEvent(newEvent, data);
		}
		
	}
	
	public void N2O_TEMP(String data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			N2O_TEMP_ObjectEvent newEvent = new N2O_TEMP_ObjectEvent(this);
			listenerCopy.N2O_TEMP_ObjectEvent(newEvent, data);
		}
		
	}

	public void Orientation_Graphic(Double data) {
		Vector<GSBackground> copy;
		
		synchronized(this) {
			copy = (Vector<GSBackground>) listener.clone();
		}
		
		for(int i = 0; i < copy.size(); i++) {
			GSBackground listenerCopy = (GSBackground) copy.elementAt(i);
			Orientation_Graphic_ObjectEvent newEvent = new Orientation_Graphic_ObjectEvent(this);
			listenerCopy.Orientation_Graphic_ObjectEvent(newEvent, data);
		}
		
	}
	

}
