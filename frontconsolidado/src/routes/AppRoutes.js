import React from "react";

import { BrowserRouter as  Router, Routes, Route, Link } from "react-router-dom";

import Layout from "../containers/LayoutPrincipal/LayoutPrincipal";
import Home from "../components/home/Home";
import TeamMembers from "../components/TeamMembers/TeamMembers";
import NotFound from "../components/notfound/NotFound";

const AppRoutes = () => (
    <Router>
        <Layout>
            <Routes>
                <Route path="/" exact element={<Home/>}/>
                <Route path="/TeamMembers" exact element={<TeamMembers/>}/>
                <Route element={<NotFound/>}/>
            </Routes>
        </Layout>
    </Router>
);
export default AppRoutes;