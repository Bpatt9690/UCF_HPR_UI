package Interface;

import java.util.EventListener;

public interface GSBackground extends EventListener {
	
	public void ActuatorATimeOutEvent(ActuatorATimeOutObjectEvent e, int time);
	public void ActuatorBTimeOutEvent(ActuatorBTimeOutObjectEvent e, int time);
	public void DataAcquisitionObjectEvent(DataAcquisitionObjectEvent e, String data);
	
	public void GYR_X_ObjectEvent(GYR_X_ObjectEvent e, String data);
	public void GYR_Y_ObjectEvent(GYR_Y_ObjectEvent e, String data);
	public void GYR_Z_ObjectEvent(GYR_Z_ObjectEvent e, String data);
	
	public void ACC_X_ObjectEvent(ACC_X_ObjectEvent e, String data);
	public void ACC_Y_ObjectEvent(ACC_Y_ObjectEvent e, String data);
	public void ACC_Z_ObjectEvent(ACC_Z_ObjectEvent e, String data);

	
	public void PRESSURE_ObjectEvent(PRESSURE_ObjectEvent e, String data);
	public void WEIGHT_ObjectEvent(WEIGHT_ObjectEvent e, String data);
	public void N2O_TEMP_ObjectEvent(N2O_TEMP_ObjectEvent e, String data);
	
	public void Orientation_Graphic_ObjectEvent(Orientation_Graphic_ObjectEvent e, double data);
	
}
