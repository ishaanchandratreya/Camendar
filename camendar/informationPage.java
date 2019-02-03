package com.wangyyt_1013.camendar;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class informationPage extends AppCompatActivity {


//    void insertEvent(String summary, String location, String description, String startTime, String endTime) {
//
//        Event event = new Event().setSummary(summary).setLocation(location).setDescription(description);
//
//        DateTime startDateTime = new DateTime(startTime);
//        EventDateTime start = new EventDateTime().setDateTime(startDateTime);
//        event.setStart(start);
//
//        DateTime endDateTime = new DateTime(endTime);
//        EventDateTime end = new EventDateTime().setDateTime(endDateTime);
//        event.setEnd(end);
//
//        String calendarId = "primary";
//        if (mService != null) {
//            mService.events().insert(calendarId, event).setSendNotifications(true).execute();
//        }
//    }

    private void insertEvent(String summary, String location, String description, String startTime, String endTime) {
        ContentValues l_event = new ContentValues();
        l_event.put("calendar_id", "primary");
        l_event.put("title", summary);
        l_event.put("description", description);
        l_event.put("eventLocation", location);
        l_event.put("dtstart", startTime);
        l_event.put("dtend", endTime);
        l_event.put("allDay", 0);
        //status: 0~ tentative; 1~ confirmed; 2~ canceled
        l_event.put("eventStatus", 1);
        //0~ default; 1~ confidential; 2~ private; 3~ public
        l_event.put("visibility", 1);
        //0~ opaque, no timing conflict is allowed; 1~ transparency, allow overlap of scheduling
        l_event.put("transparency", 1);
        //0~ false; 1~ true
        l_event.put("hasAlarm", 1);
        Uri l_eventUri;
        l_eventUri = Uri.parse("content://com.android.calendar/events");
        Uri l_uri = this.getContentResolver().insert(l_eventUri, l_event);
        Log.v("++++++test", l_uri.toString());
    }

    public void saveClicked(View view) {

        EditText titleUserEditText = (EditText) findViewById(R.id.titleEditText);
        EditText locationUserEditText = (EditText) findViewById(R.id.locationEditText);
        EditText descriptionUserEditText = (EditText) findViewById(R.id.descriptionEditText);
        EditText startTimeUserEditText = (EditText) findViewById(R.id.startTimeEditText);
        EditText endTimeUserEditText = (EditText) findViewById(R.id.endTimeEditText);

        String summary = titleUserEditText.getText().toString();
        String description = descriptionUserEditText.getText().toString();
        String location = locationUserEditText.getText().toString();
        String rawStartTime = startTimeUserEditText.getText().toString();
        String rawEndTime = endTimeUserEditText.getText().toString();

        String startTime = rawStartTime.substring(0, 10) + "T" + rawStartTime.substring(11, 16) + ":00-05:00";
        String endTime = rawEndTime.substring(0, 10) + "T" + rawEndTime.substring(11, 16) + ":00-05:00";

        String[] paras = {summary, description, location, rawStartTime, rawEndTime};
        Event_customized eventSave = new Event_customized(paras);

        System.out.println(eventSave);

        EventList.addEvent(eventSave);

        insertEvent(summary, location, description, rawStartTime, rawEndTime);

        Intent toSearchMainPage = new Intent(this, searchMainPage.class);
        startActivity(toSearchMainPage);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);
    }
}
