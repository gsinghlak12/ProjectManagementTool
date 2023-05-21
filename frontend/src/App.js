import './App.css';
import Header from './components/Layout/Header';
import Dashboard from './components/Dashboard';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom"
import AddProject from './components/Project/AddProject';
import { Provider } from 'react-redux';
import store from './store';

function App() {
  return (
    <Provider store={store}>
    <Router>
      <div className="App">
        <Header />
        <Routes>
          <Route path="/dashboard" Component={Dashboard} />
          <Route path="/addProject" Component={AddProject} />
        </Routes>
      </div>
    </Router>
    </Provider>
  );
}

export default App;
