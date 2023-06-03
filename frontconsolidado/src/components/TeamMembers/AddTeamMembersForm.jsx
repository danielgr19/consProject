import React, { useState } from "react";

const AddTeamMembersForm = (props) => {

const initialFormState = { id: null, description: "", type_of_project: "" };
const [teamMembers, setTeamMembers] = useState(initialFormState);

const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setTeamMembers({ ...teamMembers, [name]: value });
};

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!teamMembers.description
           || !teamMembers.type_of_project)
          return;

        props.addTeamMembers(teamMembers);
        setTeamMembers(initialFormState);
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

      <button>Add new Project Type</button>
    </form>
  );
};
export default AddTeamMembersForm;