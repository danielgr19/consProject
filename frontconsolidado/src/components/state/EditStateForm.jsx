import React, { useState, useEffect } from "react";

const EditStateForm = (props) => {
  const [state, setState] = useState(props.currentState);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setState({ ...state, [name]: value });
  };

  useEffect(() => {
    setState(props.currentState);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateState(state.id, state);
      }}
    >
      <label>State Name</label>
      <input
        type="text"
        name="stateName"
        value={state.stateName}
        onChange={handleInputChange}
      />
      <label>descripcion</label>
      <input
        type="text"
        name="descripcion"
        value={state.descripcion}
        onChange={handleInputChange}
      />


      <button>Update state</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};

export default EditStateForm;
