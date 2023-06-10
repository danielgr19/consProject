import React, { useState } from "react";

const AddProjectForm = (props) => {

const initialFormState = { id: null, projectName: "", codeName: "" , email: ""};
const [project, setProject] = useState(initialFormState);

const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setProject({ ...project, [name]: value });
};

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!project.projectName || !project.codeName || !project.email)
          return;

        props.addProject(project);
        setProject(initialFormState);
      }}
    >
      <label>First Name</label>
      <input
        type="text"
        name="projectName"
        value={project.projectName}
        onChange={handleInputChange}
      />
      <label>  Username: </label>
      <input
        type="text"
        name="codeName"
        value={project.codeName}
        onChange={handleInputChange}
      />

      <label>email</label>
      <input
        type="text"
        name="email"
        value={project.email}
        onChange={handleInputChange}
      />
      <button>Add new project</button>
    </form>
  );
};
export default AddProjectForm;
