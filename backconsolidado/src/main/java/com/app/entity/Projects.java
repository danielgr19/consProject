package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Projects 
{
    private List<Project> projectList;
    
    public List<Project> getProjectList() {
        if(projectList == null) {
        	projectList = new ArrayList<>();
        }
        return projectList;
    }
 
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
