package com.wangyyt_1013.camendar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EventList {

    static ArrayList<Event_customized> eventList = new ArrayList<Event_customized>();

    public static void addEvent (Event_customized event){

        eventList.add(event);

    }

    public static String printOut (){

        String names = "";

        for (Event_customized i : eventList){

            names += i.toString();

        }

        return names;

    }

    public static ArrayList<Event_customized> getList(){

        return eventList;

    }

}
