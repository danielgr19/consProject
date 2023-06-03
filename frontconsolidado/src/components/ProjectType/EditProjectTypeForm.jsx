import React, { useState, useEffect } from "react";

const EditProjectTypeForm = (props) => {
  const [projectType, setProjectType] = useState(props.currentProjectType);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setProjectType({ ...projectType, [name]: value });
  };

  useEffect(() => {
    setProjectType(props.currentProjectType);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateProjectType(projectType.id, projectType);
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



      <button>Update ProjectType</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};
export default EditProjectTypeForm;