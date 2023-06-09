import React from "react";

import { BrowserRouter as  Router, Routes, Route, Link } from "react-router-dom";

import Layout from "../containers/LayoutPrincipal/LayoutPrincipal";
import Home from "../components/home/Home";
import TeamMembers from "../components/TeamMembers/TeamMembers";
import State from "../components/state/State";
import Project from "../components/project/Project";
import ProjectType from "../components/ProjectType/ProjectType";
import Task from "../components/task/Task";
import NotFound from "../components/notfound/NotFound";

const AppRoutes = () => (
    <Router>
        <Layout>
            <Routes>
                <Route path="/" exact element={<Home/>}/>
                <Route path="/TeamMembers" exact element={<TeamMembers/>}/>
                <Route path="/ProjectType" exact element={<ProjectType/>}/>
                <Route path="/Project" exact element={<Project/>}/>
                <Route path="/State" exact element={<State/>}/>
                <Route path="/Task" exact element={<Task/>}/>
                
                <Route element={<NotFound/>}/>
            </Routes>
        </Layout>
    </Router>
);
export default AppRoutes;