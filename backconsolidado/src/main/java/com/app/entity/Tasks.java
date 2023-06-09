package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

    private List<Task> taskList;
    
    public List<Task> getTaskList() {
        if(taskList == null) {
            taskList = new ArrayList<>();
        }
        return taskList;
    }
 
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
