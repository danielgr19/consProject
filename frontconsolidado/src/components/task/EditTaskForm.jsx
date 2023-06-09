import React, { useState, useEffect } from "react";

const EditTaskForm = (props) => {
  const [task, setTask] = useState(props.currentTask);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setTask({ ...task, [name]: value });
  };

  useEffect(() => {
    setTask(props.currentTask);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateTask(task.taskId, task);
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

      <button>Update Task</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};

export default EditTaskForm
