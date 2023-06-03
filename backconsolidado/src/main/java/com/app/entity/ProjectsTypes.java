package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class ProjectsTypes{

    private List<ProjectType> projectTypeList;
	
    public List<ProjectType> getProjectTypeList() {
    	
        if(projectTypeList == null) {
        	projectTypeList = new ArrayList<>();
        }
        return projectTypeList;
    }
 
    public void setProjectTypeList(List<ProjectType> projectTypeList) {
        this.projectTypeList = projectTypeList;
    }
}
	



