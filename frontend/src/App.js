import './App.css';
import Header from './components/Layout/Header';
import Dashboard from './components/Dashboard';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom"
import AddProject from './components/Project/AddProject';

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Routes>
          <Route path="/dashboard" Component={Dashboard} />
          <Route path="/addProject" Component={AddProject} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
