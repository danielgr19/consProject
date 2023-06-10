import React, { useState, useEffect } from "react";
import "../Common/Styles/styles.scss";
import ProjectTable from "./ProjectTable";
import AddProjectForm from "./AddProjectForm";
import EditProjectForm from "./EditProjectForm";
import axios from "axios";

const Project = () => {
  const ProjectData = [
    { id: 1, firsName: "Juan", codeName: "Tania", email: "floppydiskette" },
    { id: 2, firsName: "Perez", codeName: "Craig", email: "siliconeidolon" },
    { id: 3, firsName: "guerra", codeName: "Ben", email: "benisphere" },
  ];
  const [projects, setProjects] = useState(ProjectData);
  const [showLoading, setShowLoading] = useState(true);
  const apiUrl = "http://localhost:9000/api/projectCustomAPI/";

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "projectgetall");
      setProjects(result.data.projectList);
    };
    fetchData();
  }, []);



  const addProject = (project) => {
    setShowLoading(true);
    const data = {
      id: project.id,
      projectName: project.projectName,
      codeName: project.codeName,
      email: project.email,
    };
    axios
      .post(apiUrl + "addproject", data)
      .then((result) => {
        setProjects([...projects, result.data]);
      })
      .catch((error) => setShowLoading(false));

    /*
    project.id = projects.length + 1;
    setProjects([...projects, project]);

    const data = {
      id: parseInt(project.id),
      projectName: project.projectName,
      codeName: project.codeName,
      email: project.email,
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

  const deleteProject = (id) => {
    setProjects(projects.filter((project) => project.id !== id));
    const data = {
      id: id,
      projectName: "",
      codeName: "",
      email: "",
    };
    axios
      .post(apiUrl + "projectremove", data)
      .then((result) => {
        //console.log(result);
      })
      .catch((error) => setShowLoading(false));
  };

  const [editing, setEditing] = useState(false);

  const initialFormState = {
    id: null,
    projectName: "",
    codeName: "",
    email: "",
  };

  const [currentProject, setCurrentProject] = useState(initialFormState);

  const editRow = (project) => {
    setEditing(true);
    setCurrentProject({
      id: project.id,
      projectName: project.projectName,
      codeName: project.codeName,
      email: project.email,
    });
  };

  const updateProject = (id, updatedProject) => {
    setEditing(false);
    setProjects(
      projects.map((project) =>
        project.id === id ? updatedProject : project
      )
    );
    const data = {
      id: updatedProject.id,
      projectName: updatedProject.projectName,
      codeName: updatedProject.codeName,
      email: updatedProject.email,
    };
    axios
      .post(apiUrl + "updateproject", data)
      .then((result) => {
        //console.log("Updated");
      })
      .catch((error) => setShowLoading(false));
  };

  return (
    <div className="container">
      <h1>Projects</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <div>
              <h2>Edit Project</h2>
              <EditProjectForm
                setEditing={setEditing}
                currentProject={currentProject}
                updateProject={updateProject}
              />
            </div>
          ) : (
            <div>
              <h2>Add project</h2>
              <AddProjectForm addProject={addProject} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>View Projects</h2>
          <ProjectTable
            projects={projects}
            deleteProject={deleteProject}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default Project;



