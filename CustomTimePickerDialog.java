package josu.lospinos.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import josu.lospinos.R;

/**
 * Created by josu on 8/10/2017.
 */

public class CustomTimePickerDialog extends Dialog {
    TimePicker picker;
    Button cancel,accept;

    private CustomTimePickerDialog.onCustomTimeSetListener timeSetListener;

    public CustomTimePickerDialog(@NonNull Context context, CustomTimePickerDialog.onCustomTimeSetListener listener,int hour,int minute,boolean is24H) {
        super(context);
        setContentView(R.layout.custom_time_picker_dialog);
        picker =(TimePicker) findViewById(R.id.timePicker_custom);
        picker.setCurrentHour(hour);
        picker.setCurrentMinute(minute);
        picker.setIs24HourView(is24H);


        timeSetListener = listener;

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button_cancel:
                        dismiss();
                        break;
                    case R.id.button_accept:
                        timeSetListener.onTimeSet(picker,picker.getCurrentHour(),picker.getCurrentMinute());
                        dismiss();
                        break;
                }
            }
        };

        cancel = (Button) findViewById(R.id.button_cancel);
        cancel.setOnClickListener(clickListener);

        accept = (Button) findViewById(R.id.button_accept);
        accept.setOnClickListener(clickListener);

    }

    public TimePicker getPicker() {
        return picker;
    }


    public interface onCustomTimeSetListener {
        void onTimeSet(TimePicker picker, int selectedHour, int selectedMinute);

    }
}
