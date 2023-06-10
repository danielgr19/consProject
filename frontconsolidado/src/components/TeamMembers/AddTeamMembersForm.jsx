import React, { useState } from "react";
import "../Common/Styles/styles.scss";

const AddTeamMembersForm = (props) => {

const initialFormState = { id: null, name: "", lastName: "" , rol: ""};
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
        if (!teamMembers.name || !teamMembers.lastName || !teamMembers.rol)
          return;

        props.addTeamMembers(teamMembers);
        setTeamMembers(initialFormState);
      }}
    >
      <label> Name: </label>
      <input
        type="text"
        name="name"
        value={teamMembers.name}
        onChange={handleInputChange}
      />
      <label> Last name: </label>
      <input
        type="text"
        name="lastName"
        value={teamMembers.lastName}
        onChange={handleInputChange}
      />

      <label> Rol: </label>
      <input
        type="text"
        name="rol"
        value={teamMembers.rol}
        onChange={handleInputChange}
      />
      <button className='button'>Add</button>
    </form>
  );
};
export default AddTeamMembersForm;