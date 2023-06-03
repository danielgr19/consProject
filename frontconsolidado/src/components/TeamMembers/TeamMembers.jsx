import React, { useState, useEffect } from "react";
import "./TeamMembers.scss";
import TeamMembersTable from "./TeamMembersTable";
import AddTeamMembersForm from "./AddTeamMembersForm";
import EditTeamMembersForm from "./EditTeamMembersForm";
import axios from "axios";

const TeamMembers = () => {
  const TeamMembersData = [
    { id: 1, description: "Juan", type_of_project: "Tania"},
    { id: 2, description: "Perez", type_of_project: "Craig" },
    { id: 3, description: "guerra", type_of_project: "Ben" },
  ];
  const [teamMemberss, setTeamMemberss] = useState(TeamMembersData);
  const [showLoading, setShowLoading] = useState(true);
  const apiUrl = "http://localhost:9000/api/teamMembersCustomAPI/";
  

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "teamMembersgetall");
      setTeamMemberss(result.data.teamMembersList);
    };
    fetchData();
  }, []);



  const addTeamMembers = (teamMembers) => {
    setShowLoading(true);
    const data = {
      id: teamMembers.id,
      name: teamMembers.name,
      lastName: teamMembers.lastName,
      rol: teamMembers.rol,
    };
    axios
      .post(apiUrl + "addteamMembers", data)
      .then((result) => {
        setEmployees([...teamMemberss, result.data]);
      })
      .catch((error) => setShowLoading(false));

    /*
    employee.id = employees.length + 1;
    setEmployees([...employees, employee]);

    const data = {
      id: parseInt(employee.id),
      firstName: employee.firstName,
      lastName: employee.lastName,
      email: employee.email,
    };

    axios
      .post(apiUrl, data)
      .then((result) => {
        //props.history.push('/show/' + result.data._id)
        console.log("Consumo del Servicio 2");
        console.log(result);
      })
      .catch((error) => setShowLoading(false));
*/
  };

  const deleteTeamMembers = (id) => {
    setTeamMemberss(teamMemberss.filter((teamMembers) => teamMembers.id !== id));
    const data = {
      id: id,
      description: "",
      type_of_project: "",
    };
    axios
      .post(apiUrl + "teamMembersremove", data)
      .then((result) => {
        //console.log(result);
      })
      .catch((error) => setShowLoading(false));
  };

  const [editing, setEditing] = useState(false);

  const initialFormState = {
    id: null,
    description: "",
    type_of_project: "",
  };

  const [currentTeamMembers, setCurrentTeamMembers] = useState(initialFormState);

  const editRow = (teamMembers) => {
    setEditing(true);
    setCurrentTeamMembers({
      id: teamMembers.id,
      description: teamMembers.description,
      type_of_project: teamMembers.type_of_project,
    });
  };

  const updateTeamMembers = (id, updatedTeamMembers) => {
    setEditing(false);
    setTeamMemberss(
        teamMemberss.map((teamMembers) =>
        teamMembers.id === id ? updatedTeamMembers : teamMembers
      )
    );
    const data = {
      id: updatedTeamMembers.id,
      description: updatedTeamMembers.name,
      type_of_project: updatedTeamMembers.lastName,
    };
    axios
      .post(apiUrl + "updateteamMembers", data)
      .then((result) => {
        //console.log("Updated");
      })
      .catch((error) => setShowLoading(false));
  };

  return (
    <div className="container">
      <h1>CRUD App with Hooks</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <div>
              <h2>Edit Project Type</h2>
              <EditTeamMembersForm
                setEditing={setEditing}
                currentTeamMembers={currentTeamMembers}
                updateTeamMembers={updateTeamMembers}
              />
            </div>
          ) : (
            <div>
              <h2>Add Project Type</h2>
              <AddTeamMembersForm addTeamMembers={addTeamMembers} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>View Project Types</h2>
          <TeamMembersTable
            teamMemberss={teamMemberss}
            deleteTeamMembers={deleteTeamMembers}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default TeamMembers;