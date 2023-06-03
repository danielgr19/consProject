import React from "react";

const StateTable = (props) => (
  <table>
    <thead>
      <tr>
      <td>ID BD</td>
        <td>stateName</td>
        <td>descripcion</td>
      </tr>
    </thead>
    <tbody>
    {undefined !== props.states && props.states.length > 0 ? (
        props.states.map((state) => (
          <tr key={state.id.toString()}>
            <td>{state.id}</td>
            <td>{state.stateName}</td>
            <td>{state.descripcion}</td>
            <td>
              <button
                onClick={() => {
                  props.editRow(state);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => props.deleteState(state.id)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No state</td>
        </tr>
      )}
    </tbody>
  </table>
);


export default StateTable;