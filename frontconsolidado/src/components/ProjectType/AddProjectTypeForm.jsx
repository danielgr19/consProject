import React, { useState } from "react";

const AddProjectTypeForm = (props) => {

const initialFormState = { id: null, description: "", type_of_project: "" };
const [projectType, setProjectType] = useState(initialFormState);

const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setProjectType({ ...projectType, [name]: value });
};

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!projectType.description
           || !projectType.type_of_project)
          return;

        props.addProjectType(projectType);
        setProjectType(initialFormState);
      }}
    >
      <label>description</label>
      <input
        type="text"
        name="description"
        value={projectType.description}
        onChange={handleInputChange}
      />
      <label>type_of_project</label>
      <input
        type="text"
        name="type_of_project"
        value={projectType.type_of_project}
        onChange={handleInputChange}
      />

      <button>Add new Project Type</button>
    </form>
  );
};
export default AddProjectTypeForm;