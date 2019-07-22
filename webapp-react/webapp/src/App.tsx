import React from "react";
import Navbar from "./components/navbar/Navbar";
import Dashboard from "./components/dashboard/Dashboard";
import Section from "./components/section/Section";
import Subsection from './components/subsection/Subsection';
import Exercise from './components/exercise/Exercise';
import { BrowserRouter as Router, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <Route path="/" exact component={Dashboard}></Route>
        <Route path="/sections/:sectionName" exact component={Section}></Route>
        <Route path="/sections/:sectionName/subsections/:subSectionName" exact component={Subsection}></Route>
        <Route path="/sections/:sectionName/subsections/:subSectionName/exercises/:exerciseNumber" exact component={Exercise}></Route>
      </div>
    </Router>
  );
}

export default App;