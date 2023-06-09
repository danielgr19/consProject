import React, { useState, useEffect } from "react";
import "./Task.scss";
import TaskTable from "./TaskTable";
import AddTaskForm from "./AddTaskForm";
import EditTaskForm from "./EditTaskForm";
import axios from "axios";

const Task = () => {
  const TaskData = [
    { taskId: 1, taskName: "CRUD X", taskDescription: "CRUD FOR X", startDate: "02-02-2023", finishDate: "01-01-2023" },
    { taskId: 2, taskName: "CRUD Y", taskDescription: "CRUD FOR Y", startDate: "02-02-2020", finishDate: "01-01-2021" },
    { taskId: 3, taskName: "CRUD Z", taskDescription: "CRUD FOR Z", startDate: "02-02-2019", finishDate: "01-01-2020" },
  ];
  const [tasks, setTasks] = useState(TaskData);
  const [showLoading, setShowLoading] = useState(true);
  const apiUrl = "http://localhost:9000/taskAPI/";

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "taskgetall");
      setTasks(result.data.taskList);
    };
    fetchData();
  }, []);



  const addTask = (task) => {
    setShowLoading(true);
    const data = {
        taskId: task.taskId,
        taskName: task.taskName,
        taskDescription: task.taskDescription,
        startDate: task.startDate,
        finishDate: task.finishDate,
    };

    axios
      .post(apiUrl + "addtask", data)
      .then((result) => {
        setTasks([...tasks, result.data]);
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

  const deleteTask = (taskId) => {
    setTasks(tasks.filter((task) => task.taskId !== taskId));
    const data = {
        taskId: taskId,
        taskName: "",
        taskDescription: "",
        startDate: "",
        finishDate: "",
    };

    axios
      .post(apiUrl + "taskremove", data)
      .then((result) => {
        //console.log(result);
      })
      .catch((error) => setShowLoading(false));
  };

  const [editing, setEditing] = useState(false);

  const initialFormState = {
    taskId: null,
    taskName: "",
    taskDescription: "",
    startDate: "",
    finishDate: "",
  };

  const [currentTask, setCurrentTask] = useState(initialFormState);

  const editRow = (task) => {
    setEditing(true);
    setCurrentTask({
        taskId: task.taskId,
        taskName: task.taskName,
        taskDescription: task.taskDescription,
        startDate: task.startDate,
        finishDate: task.finishDate,
    });
  };

  const updateTask = (taskId, updatedTask) => {
    setEditing(false);
    setTasks(
      tasks.map((task) =>
        task.taskId === taskId ? updatedTask : task
      )
    );

    const data = {
      taskId: updatedTask.taskId,
      taskName: updatedTask.taskName,
      taskDescription: updatedTask.taskDescription,
      startDate: updatedTask.startDate,
      finishDate: updatedTask.finishDate,
    };

    axios
      .post(apiUrl + "updatetask", data)
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
              <h2>Edit Task</h2>
              <EditTaskForm
                setEditing={setEditing}
                currentTask={currentTask}
                updateTask={updateTask}
              />
            </div>
          ) : (
            <div>
              <h2>Add Task</h2>
              <AddTaskForm addTask={addTask} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>View Tasks</h2>
          <TaskTable
            tasks={tasks}
            deleteTask={deleteTask}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default Task;
