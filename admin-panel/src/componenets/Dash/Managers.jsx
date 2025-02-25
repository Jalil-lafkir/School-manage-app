import "../../Style.css";
import { useNavigate } from "react-router-dom";

const Managers = () => {
  const navigate = useNavigate();
  return (
    <>
      <div className="absolute top-1/2 transform -translate-y-1/2 flex flex-col px-28 gap-y-4">
        <button
          className="ManagerButtonStyle"
          id=""
          onClick={() => navigate("/dashboard/managers/student")}
        >
          <span>Manage Students</span>
        </button>
        <button
          className="ManagerButtonStyle"
          id=""
          onClick={() => navigate("/dashboard/managers/proffesor")}
        >
          <span>Manage Professors</span>
        </button>
        <button
          className="ManagerButtonStyle"
          id=""
          onClick={() => navigate("/dashboard/managers/module")}
        >
          <span>Manage Modules</span>
        </button>
        <button
          className="ManagerButtonStyle"
          id=""
          onClick={() => navigate("/dashboard/managers/session")}
        >
          <span>Manage Sessions</span>
        </button>
        <button
          className="ManagerButtonStyle"
          id=""
          onClick={() => navigate("/dashboard/managers/room")}
        >
          <span>Manage Rooms</span>
        </button>
        <button
          className="ManagerButtonStyle"
          id=""
          onClick={() => navigate("/dashboard/managers/services")}
        >
          <span>Some services Manger </span>
        </button>
      </div>
      <div>
        <img
          className="absolute z-20 top-1/2 transform -translate-y-1/2 right-0"
          src="/home/jalil-lafkir/me.files/Projects/Java/School-manage-app/dashboard/src/assets/uml.png"
          alt=""
        />
      </div>
    </>
  );
};

export default Managers;
