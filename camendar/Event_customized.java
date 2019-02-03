package com.wangyyt_1013.camendar;

public class Event_customized {

    private String summary;
    private String location;
    private String description;
    private String startTime;
    private String endTime;
    private boolean science;
    private boolean engineering;
    private boolean socialScience;
    private boolean finance;
    private boolean artHumanities;

    public Event_customized (String[] paras){
        summary = paras[0];
        location = paras[1];
        description = paras[2];
        startTime = paras[3];
        endTime = paras[4];
        science = false;
        engineering = false;
        socialScience = false;
        finance = false;
        artHumanities = false;
    }

    public String toString() {
        return summary;
    }

    public void setScience() {
        if (!science) {
            science = true;
        }

        else {
            science = false;
        }
    }

    public void setEngineering() {
        if (!engineering) {
            engineering = true;
        }

        else {
            engineering = false;
        }
    }

    public void setSocialScience() {
        if (!socialScience) {
            socialScience = true;
        }

        else {
            socialScience = false;
        }
    }

    public void setFinance() {
        if (!finance) {
            finance = true;
        }

        else {
            finance = false;
        }
    }

    public void setArtHumanities() {
        if (!artHumanities) {
            artHumanities = true;
        }

        else {
            artHumanities = false;
        }
    }

}
