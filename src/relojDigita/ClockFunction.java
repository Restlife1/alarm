package relojDigita;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JLabel;

/**
 *
 * @author Ivet
 */
public class ClockFunction extends JLabel implements Serializable{
    
    private boolean format24h;
    private Alarma alarmFunc;
    
    private SimpleDateFormat sdf24h;
    private SimpleDateFormat sdf12h;
    private Timer timer;
    private AlarmListener alarmListener;
    
    public ClockFunction(){       
        
        timer = new Timer(0, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                Date currentTime = new Date();
                if(format24h){
                    
                    String formatTime24 = "HH:mm:ss";
                    sdf24h = new SimpleDateFormat(formatTime24);
                    DateFormat formTime24 = new SimpleDateFormat(formatTime24);
                    String formattedTime24 = formTime24.format(currentTime);
                    setText(formattedTime24);
                    
                }
                else{
                    
                    String formatTime12 = "hh:mm:ss a";
                    sdf12h = new SimpleDateFormat(formatTime12);
                    DateFormat formTime12 = new SimpleDateFormat(formatTime12);
                    String formattedTime12 = formTime12.format(currentTime);
                    setText(formattedTime12);
                    
                }
                
                if(alarmFunc != null){
                    
                    if(alarmFunc.isOn() && timeMatch(currentTime, alarmFunc.getAlarmProgram())){
                        
                        if(alarmListener != null){
                            
                            alarmListener.rings();
                            
                        }
                        
                    }
                    
                }
                
            }
        
        });
        
        timer.start();
    }

    public boolean isFormat24h() {
        return format24h;
    }

    public void setFormat24h(boolean format24h) {
        this.format24h = format24h;
    }

    public Alarma getAlarmFunc() {
        return alarmFunc;
    }

    public void setAlarmFunc(Alarma alarmFunc) {
        this.alarmFunc = alarmFunc;
    }

    public AlarmListener getAlarmListener() {
        return alarmListener;
    }

    public void addAlarmListener(AlarmListener alarmListener) {
        this.alarmListener = alarmListener;
    }   
    
    private boolean timeMatch(Date currentTime, Date alarmTime){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        int actualHours, actualMin, actualSec, actualAlarmHours, actualAlarmMin, actualAlarmSec;
        actualHours = calendar.get(Calendar.HOUR_OF_DAY);
        actualMin = calendar.get(Calendar.MINUTE);
        actualSec = calendar.get(Calendar.SECOND);
        calendar.setTime(alarmTime);
        actualAlarmHours = calendar.get(Calendar.HOUR_OF_DAY);
        actualAlarmMin = calendar.get(Calendar.MINUTE);
        actualAlarmSec = calendar.get(Calendar.SECOND);
        
        if(actualHours == actualAlarmHours && actualMin == actualAlarmMin && actualSec == actualAlarmSec){            
            return true;            
        }else{            
            return false;            
        }
        
    }
    
}