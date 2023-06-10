import React from "react";

const ProjectTable = (props) => (
  <table>
    <thead>
      <tr>
        <th>ID </th>
        <th> ProjectName</th>
        <th> Code</th>
        <th> Description  </th>
      </tr>
    </thead>
    <tbody>
      {undefined !== props.projects && props.projects.length > 0 ? (
        props.projects.map((project) => (
          <tr key={project.id.toString()}>
            <td>{project.id}</td>
            <td>{project.projectName}</td>
            <td>{project.codeName}</td>
            <td>{project.email}</td>
            <td>
              <button
                onClick={() => {
                  props.editRow(project);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => props.deleteProject(project.id)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No project</td>
        </tr>
      )}
    </tbody>
  </table>
);

export default ProjectTable;
