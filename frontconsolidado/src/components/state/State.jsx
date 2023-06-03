import React, { useState, useEffect }  from "react";
import './State.scss';
import StateTable from "./StateTable";
import AddStateForm from "./AddStateForm";
import EditStateForm from "./EditStateForm";
import axios from "axios";


const State = () => {
    const StateData = [
        { id: 1, stateName: "Activo", descripcion: "Act"},
        { id: 2, stateName: "Finalizado", descripcion: "Finished"},
        { id: 3, stateName: "Cancelado", descripcion: "Canceled"},
      ];
      const [states, setState] = useState(StateData);
      const [showLoading, setShowLoading] = useState(true);
      const apiUrl = "http://localhost:9000/api/stateCustomAPI/";

      useEffect(() => {
        const fetchData = async () => {
          const result = await axios(apiUrl + "stategetall");
          setState(result.data.stateList);
        };
        fetchData();
      }, []);
    
    
    
      const addState = (state) => {
        setShowLoading(true);
        const data = {
          id: state.id,
          stateName: state.stateName,
          descripcion: state.descripcion,
         
        };
        axios
          .post(apiUrl + "addstate", data)
          .then((result) => {
            setState([...states, result.data]);
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
    
      const deleteState = (id) => {
        setState(states.filter((state) => state.id !== id));
        const data = {
          id: id,
          stateName: "",
          descripcion: "",
          
        };
        axios
          .post(apiUrl + "stateremove", data)
          .then((result) => {
            //console.log(result);
          })
          .catch((error) => setShowLoading(false));
      };
    
      const [editing, setEditing] = useState(false);
    
      const initialFormState = {
        id: null,
        stateName: "",
        descripcion: "",
      };
    
      const [currentState, setCurrentState] = useState(initialFormState);
    
      const editRow = (state) => {
        setEditing(true);
        setCurrentState({
          id: state.id,
          stateName: state.stateName,
          descripcion: state.descripcion,
        });
      };
    
      const updateState = (id, updatedState) => {
        setEditing(false);
        setState(
          states.map((state) =>
            state.id === id ? updatedState : state
          )
        );
        const data = {
          id: updatedState.id,
          stateName: updatedState.stateName,
          descripcion: updatedState.descripcion,
          
        };
        axios
          .post(apiUrl + "updatestate", data)
          .then((result) => {
            //console.log("Updated");
          })
          .catch((error) => setShowLoading(false));
      };
    
        return (
    <div className="container">
      <h1>CRUD App with Hooks</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <div>
              <h2>Edit State</h2>
              <EditStateForm
                setEditing={setEditing}
                currentState={currentState}
                updateState={updateState}
              />
            </div>
          ) : (
            <div>
              <h2>Add state</h2>
              <AddStateForm addState={addState} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>View States</h2>
          <StateTable
            states={states}
            deleteState={deleteState}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default State;
