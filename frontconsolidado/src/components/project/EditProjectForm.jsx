import React, { useState, useEffect } from "react";

const EditProjectForm = (props) => {
  const [project, setProject] = useState(props.currentProject);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setProject({ ...project, [name]: value });
  };

  useEffect(() => {
    setProject(props.currentProject);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateProject(project.id, project);
      }}
    >
      <label>First Name</label>
      <input
        type="text"
        name="projectName"
        value={project.projectName}
        onChange={handleInputChange}
      />
      <label>Last name</label>
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

      <button>Update project</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};

export default EditProjectForm;
