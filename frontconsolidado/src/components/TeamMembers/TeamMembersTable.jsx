import React from "react";
import "../Common/Styles/styles.scss";

const TeamMembersTable = (props) => (
  <table>
    <thead>
      <tr>
        <th>ID BD</th>
        <th>name</th>
        <th>lastName</th>
        <th>rol</th>
      </tr>
    </thead>
    <tbody>
        {undefined !== props.teamMemberss && props.teamMemberss.length > 0 ? (
            props.teamMemberss.map((teamMembers) => (
                <tr key={teamMembers.id.toString()}>
                  <td>{teamMembers.id}</td>
                  <td>{teamMembers.name}</td>
                  <td>{teamMembers.lastName}</td>
                  <td>{teamMembers.rol}</td>
                  <td>
                    <button
                      onClick={() => {
                        props.editRow(teamMembers);
                      }}
                      className="button muted-button">
                        Edit
                      </button>
                      <button className='button'
                        onClick={() => props.deleteTeamMembers(teamMembers.id)}>
                          Delete
                        </button>
                  </td>
                </tr>
            ))
        ) : (
          <tr>
            <td colSpan={3}>No team Members</td>
          </tr>
        )}
    </tbody>
  </table>
);

export default TeamMembersTable;