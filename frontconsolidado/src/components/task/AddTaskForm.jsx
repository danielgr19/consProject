import React, { useState } from "react";

const AddTaskForm = (props) => {

const initialFormState = { id: null, taskName: "", taskDescription: "" , startDate: "", finishDate: ""};
const [task, setTask] = useState(initialFormState);

const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setTask({ ...task, [name]: value });
};

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!task.taskName || !task.taskDescription || !task.startDate || !task.finishDate)
          return;

        props.addTask(task);
        setTask(initialFormState);
      }}
    >

    <label>Task Name</label>
      <input
        type="text"
        name="taskName"
        value={task.taskName}
        onChange={handleInputChange}
      />

      <label>Task Description</label>
      <input
        type="text"
        name="taskDescription"
        value={task.taskDescription}
        onChange={handleInputChange}
      />

      <label>Start Date</label>
      <input
        type="text"
        name="startDate"
        value={task.startDate}
        onChange={handleInputChange}
      />
      
      <label>Finish Date</label>
      <input
        type="text"
        name="finishDate"
        value={task.finishDate}
        onChange={handleInputChange}
      />

      <button>Add new task</button>
    </form>
  );
};
export default AddTaskForm;
