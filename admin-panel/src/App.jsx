import { BrowserRouter, Route, Routes } from "react-router-dom";
import AuthPanel from "./componenets/AuthPanel";
import Managers from "./componenets/Dash/Managers";
import Module from "./componenets/Dash/Managers/Module";
import Professor from "./componenets/Dash/Managers/Professor";
import Room from "./componenets/Dash/Managers/Room";
import Session from "./componenets/Dash/Managers/Session";
import Student from "./componenets/Dash/Managers/Student";
import Dashboard from "./componenets/Dashboard";
import "./Style.css";
import Services from "./componenets/Dash/Managers/Services";

function App() {
  const admin = localStorage.getItem("admin");
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={admin ? <Dashboard /> : <AuthPanel />} />
        <Route
          path="/dashboard"
          element={admin ? <Dashboard /> : <AuthPanel />}
        />
        <Route path="/dashboard/managers">
          <Route index element={admin ? <Managers /> : <AuthPanel />} />
          <Route
            path="/dashboard/managers/student"
            element={admin ? <Student /> : <AuthPanel />}
          />
          <Route
            path="/dashboard/managers/proffesor"
            element={admin ? <Professor /> : <AuthPanel />}
          />
          <Route
            path="/dashboard/managers/module"
            element={admin ? <Module /> : <AuthPanel />}
          />
          <Route
            path="/dashboard/managers/session"
            element={admin ? <Session /> : <AuthPanel />}
          />
          <Route
            path="/dashboard/managers/room"
            element={admin ? <Room /> : <AuthPanel />}
          />
          <Route
            path="/dashboard/managers/services"
            element={admin ? <Services /> : <AuthPanel />}
          />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
export default App;
