package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class States 
{
    private List<State> stateList;
    
    public List<State> getStateList() {
        if(stateList == null) {
        	stateList = new ArrayList<>();
        }
        return stateList;
    }
 
    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

}
