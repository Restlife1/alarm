 package relojDigita;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 *
 * @author Ivet
 */
public class AlarmPropertyEditorSupport extends PropertyEditorSupport{
    
    private AlarmVisualPane alarmVP = new AlarmVisualPane();
    
    @Override
    public boolean supportsCustomEditor(){
        return true;
    }
    
    @Override
    public Component getCustomEditor(){
        return alarmVP;
    }
    
    @Override
    public String getJavaInitializationString(){
        
        Date AlarmSet = alarmVP.getSelectedValue().getAlarmProgram();
        boolean on = alarmVP.getSelectedValue().isOn();
        return "new relojDigita.Alarma(new java.util.Date("+AlarmSet.getTime()+"l),"+on+")";
        
    }
    
    @Override
    public Object getValue(){
        
        return alarmVP.getSelectedValue();
        
    }
    
}
