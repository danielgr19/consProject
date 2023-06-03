import React, { useState, useEffect } from "react";

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
      <label>description</label>
      <input
        type="text"
        name="description"
        value={teamMembers.description}
        onChange={handleInputChange}
      />
      <label>type_of_project</label>
      <input
        type="text"
        name="type_of_project"
        value={teamMembers.type_of_project}
        onChange={handleInputChange}
      />



      <button>Update TeamMembers</button>
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