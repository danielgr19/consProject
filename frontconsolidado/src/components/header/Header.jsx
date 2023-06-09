import React from "react";
import './Header.scss';
import { Link } from "react-router-dom";
//import "../assets/styles/components/Header.scss";
//import logo from "../assets/static/logo.png";

const Header = () => (
  <header className="header">
    <Link to="/">
      <img className="header__img" src="{ logo }" alt="Logo" />
    </Link>

    <div className="header__menu">
      <div className="header__menu--profile">
        <img src="{ userIcon }" alt="" />
        <p>Menu</p>
      </div>
      <ul>
        <li>
          <a href="/">Home</a>
        </li>
        <li>
          <Link to="/TeamMembers">Team Members</Link>
        </li>
        <li>
          <Link to="/ProjectType">Project Type</Link>
        </li>
        <li>
          <Link to="/project">Project</Link>
        </li>
        <li>
          <Link to="/State">State</Link>
        </li>
        <li>
          <Link to="/Task">Tasks</Link>
        </li>
      </ul>
    </div>
  </header>
  );
  export default Header;