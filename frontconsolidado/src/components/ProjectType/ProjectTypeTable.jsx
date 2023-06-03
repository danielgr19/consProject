import React from "react";

const ProjectTypeTable = (props) => (
  <table>
    <thead>
      <tr>
        <th>ID BD</th>
        <th>name</th>
        <th>lastName</th>
        <th>rol</th>
      </tr>
    </thead>
    <tbody>
        {undefined !== props.projectTypes && props.projectTypes.length > 0 ? (
            props.projectTypes.map((projectType) => (
                <tr key={projectType.id.toString()}>
                  <td>{projectType.id}</td>
                  <td>{projectType.name}</td>
                  <td>{projectType.lastName}</td>
                  <td>{projectType.rol}</td>
                  <td>
                    <button
                      onClick={() => {
                        props.editRow(projectType);
                      }}
                      className="button muted-button">
                        Edit
                      </button>
                      <button
                        onClick={() => props.deleteProjectType(projectType.id)}>
                          Delete
                        </button>
                  </td>
                </tr>
            ))
        ) : (
          <tr>
            <td colSpan={3}>No team Members</td>
          </tr>
        )}
    </tbody>
  </table>
);

export default ProjectTypeTable;