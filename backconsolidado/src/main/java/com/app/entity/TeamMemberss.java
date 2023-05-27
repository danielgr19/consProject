package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class TeamMemberss 
{
    private List<TeamMembers> teamMembersList;
    
    public List<TeamMembers> getTeamMembersList() {
        if(teamMembersList == null) {
        	teamMembersList = new ArrayList<>();
        }
        return teamMembersList;
    }
 
    public void setTeamMembersList(List<TeamMembers> teamMembersList) {
        this.teamMembersList = teamMembersList;
    }
}
