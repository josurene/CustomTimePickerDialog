# Android CustomTimePickerDialog
I couldn't find a time picker dialog for android API 21 that didn't use the clock mode, so here it is, just change it in the xml

# Example

CustomTimePickerDialog dialog = new CustomTimePickerDialog(getActivity(), new CustomTimePickerDialog.onCustomTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker picker, int selectedHour, int selectedMinute) {
                       
                        Toast.makeText(getActivity(), "Hour : " +selectedHour + ":"+selectedMinute , Toast.LENGTH_SHORT).show();
                    }
                }, hour, minute, true);
dialog.show();
