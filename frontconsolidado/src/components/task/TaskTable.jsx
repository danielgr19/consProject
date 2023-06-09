import React from "react";

const TaskTable = (props) => (
    <table>
        <thead>
            <tr>
                <th>ID from DB</th>
                <th>Task_Name</th>
                <th>Task_Description</th>
                <th>Start_Date</th>
                <th>Finish_Date</th>
            </tr>
        </thead>
        <tbody>
        {undefined !== props.tasks && props.tasks.length > 0 ? (
        props.tasks.map((task) => (
          <tr key={task.taskId.toString()}>
            <td>{task.taskId}</td>
            <td>{task.taskName}</td>
            <td>{task.taskDescription}</td>
            <td>{task.startDate}</td>
            <td>{task.finishDate}</td>
            <td>
              <button
                onClick={() => {
                  props.editRow(task);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => props.deleteTask(task.taskId)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No Task</td>
        </tr>
      )}

        </tbody>
    </table>
);
export default TaskTable;