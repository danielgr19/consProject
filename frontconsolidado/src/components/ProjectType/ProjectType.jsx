import React, { useState, useEffect } from "react";
import "./ProjectType.scss";
import ProjectTypeTable from "./ProjectTypeTable";
import AddProjectTypeForm from "./AddProjectTypeForm";
import EditProjectTypeForm from "./EditProjectTypeForm";
import axios from "axios";

const ProjectType = () => {
  const ProjectTypeData = [
    { id: 1, description: "Juan", type_of_project: "Tania"},
    { id: 2, description: "Perez", type_of_project: "Craig" },
    { id: 3, description: "guerra", type_of_project: "Ben" },
  ];
  const [projectTypes, setProjectTypes] = useState(ProjectTypeData);
  const [showLoading, setShowLoading] = useState(true);
  const apiUrl = "http://localhost:9000/api/projectTypeCustomAPI/";
  

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "projectTypegetall");
      setProjectTypes(result.data.projectTypeList);
    };
    fetchData();
  }, []);



  const addProjectType = (projectType) => {
    setShowLoading(true);
    const data = {
      id: projectType.id,
      name: projectType.name,
      lastName: projectType.lastName,
      rol: projectType.rol,
    };
    axios
      .post(apiUrl + "addprojectType", data)
      .then((result) => {
        setEmployees([...projectTypes, result.data]);
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

  const deleteProjectType = (id) => {
    setProjectTypes(projectTypes.filter((projectType) => projectType.id !== id));
    const data = {
      id: id,
      description: "",
      type_of_project: "",
    };
    axios
      .post(apiUrl + "projectTyperemove", data)
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

  const [currentProjectType, setCurrentProjectType] = useState(initialFormState);

  const editRow = (projectType) => {
    setEditing(true);
    setCurrentProjectType({
      id: projectType.id,
      description: projectType.description,
      type_of_project: projectType.type_of_project,
    });
  };

  const updateProjectType = (id, updatedProjectType) => {
    setEditing(false);
    setProjectTypes(
        projectTypes.map((projectType) =>
        projectType.id === id ? updatedProjectType : projectType
      )
    );
    const data = {
      id: updatedProjectType.id,
      description: updatedProjectType.name,
      type_of_project: updatedProjectType.lastName,
    };
    axios
      .post(apiUrl + "updateprojectType", data)
      .then((result) => {
        //console.log("Updated");
      })
      .catch((error) => setShowLoading(false));
  };

  return (
    <div className="container">
      <h1>Projects Types</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <div>
              <h2>Edit Project Type</h2>
              <EditProjectTypeForm
                setEditing={setEditing}
                currentProjectType={currentProjectType}
                updateProjectType={updateProjectType}
              />
            </div>
          ) : (
            <div>
              <h2>Add Project Type</h2>
              <AddProjectTypeForm addProjectType={addProjectType} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>View Project Types</h2>
          <ProjectTypeTable
            projectTypes={projectTypes}
            deleteProjectType={deleteProjectType}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default ProjectType;