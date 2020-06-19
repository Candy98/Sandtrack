package com.sandy.sandtracker.Activities.Tools;

public class StringTrimmer {
    private String result;

    public String trimStr(String name){

result=name.substring(name.indexOf("T")+1);
result.trim();

return result;

    }
}
