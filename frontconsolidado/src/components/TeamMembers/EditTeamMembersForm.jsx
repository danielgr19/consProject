import React, { useState, useEffect } from "react";
import "../Common/Styles/styles.scss";

const EditTeamMembersForm = (props) => {
  const [teamMembers, setTeamMembers] = useState(props.currentTeamMembers);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setTeamMembers({ ...teamMembers, [name]: value });
  };

  useEffect(() => {
    setTeamMembers(props.currentTeamMembers);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateTeamMembers(teamMembers.id, teamMembers);
      }}
    >
      <label>Name</label>
      <input
        type="text"
        name="name"
        value={teamMembers.name}
        onChange={handleInputChange}
      />
      <label>Last name</label>
      <input
        type="text"
        name="lastName"
        value={teamMembers.lastName}
        onChange={handleInputChange}
      />

      <label>Rol</label>
      <input
        type="text"
        name="rol"
        value={teamMembers.email}
        onChange={handleInputChange}
      />

      <button className='button'>Update Team Members</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};
export default EditTeamMembersForm;