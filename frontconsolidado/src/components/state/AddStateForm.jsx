import React, { useState } from "react";

const AddStateForm = (props) => {

const initialFormState = { id: null, stateName: "", descripcion: "" };
const [state, setState] = useState(initialFormState);

const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setState({ ...state, [name]: value });
};

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!state.stateName || !state.descripcion)
          return;

        props.addState(state);
        setState(initialFormState);
      }}
    >
      <label> State Name: </label>
      <input
        type="text"
        name="stateName"
        value={state.stateName}
        onChange={handleInputChange}
      />
      <label> Description: </label>
      <input
        type="text"
        name="descripcion"
        value={state.descripcion}
        onChange={handleInputChange}
      />

    
      <button>Add new state</button>
    </form>
  );
};
export default AddStateForm;
