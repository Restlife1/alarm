package relojDigita;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ivet
 */
public class Alarma implements Serializable{
    
    private Date alarmProgram;
    private boolean on;
    
    public Alarma(Date alarm, boolean active){
        
        this.alarmProgram = alarm;
        this.on = active;
        
    }

    public Date getAlarmProgram() {
        return alarmProgram;
    }

    public void setAlarmProgram(Date alarm) {
        this.alarmProgram = alarm;
    }
    
    public boolean isOn(){
        return on;
    }
    
    public void setOn(boolean active){
        this.on = active;
    }
    
}
