import axios from "axios";
import { useEffect, useState } from "react";
import { FaArrowAltCircleRight } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

export default function StatCards() {
  const [students, setStudents] = useState(null);
  const [professors, setProfessors] = useState(null);
  const [modules, setModules] = useState(null);
  const [sessions, setSessions] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [studentsRes, professorsRes, modulesRes, sessionsRes] =
          await Promise.all([
            axios.get("http://localhost:8080/app/rest/student"),
            axios.get("http://localhost:8080/app/rest/professor"),
            axios.get("http://localhost:8080/app/rest/module"),
            axios.get("http://localhost:8080/app/rest/session"),
          ]);

        setStudents(studentsRes.data.objects.length);
        setProfessors(professorsRes.data.objects.length);
        setModules(modulesRes.data.objects.length);
        setSessions(sessionsRes.data.objects.length);
      } catch (err) {
        console.error("Error fetching data:", err);
      }
    };

    fetchData();
  }, []);

  const navigate = useNavigate();
  const navigateToManagers = () => {
    navigate("/dashboard/managers");
  };

  return (
    <div className="grid grid-cols-1 sm:grid-cols-3 gap-4 p-4">
      <div className="bg-white w-[20rem] p-5 rounded-2xl shadow-lg border border-gray-200">
        <h3 className="text-2xl font-bold flex items-center">
          {students}
          <small className="ml-2 text-green-600 bg-green-100 px-2 py-1 rounded-full text-sm">
            +17%
          </small>
        </h3>
        <span className="text-gray-500">Total Students</span>
      </div>

      {/* Sign-ups Card */}
      <div className="bg-white p-5 rounded-2xl shadow-lg border border-gray-200">
        <h3 className="text-2xl font-bold flex items-center">
          {professors}
          <small className="ml-2 text-green-600 bg-green-100 px-2 py-1 rounded-full text-sm">
            +4%
          </small>
        </h3>
        <span className="text-gray-500">Total Professors</span>
      </div>

      {/* New Orders Card */}
      <div className="bg-white p-5 rounded-2xl shadow-lg border border-gray-200">
        <h3 className="text-2xl font-bold flex items-center">
          {sessions}
          <small className="ml-2 text-red-600 bg-red-100 px-2 py-1 rounded-full text-sm">
            -3%
          </small>
        </h3>
        <span className="text-gray-500">Total Sessions</span>
      </div>

      <div className="bg-white p-5 rounded-2xl shadow-lg border border-gray-200">
        <h3 className="text-2xl font-bold flex items-center">
          {modules}
          <small className="ml-2 text-blue-600 bg-blue-100 px-2 py-1 rounded-full text-sm">
            0%
          </small>
        </h3>
        <span className="text-gray-500">Total modules</span>
      </div>

      <button
        className="bg-white p-5 flex items-center rounded-2xl shadow-lg border border-gray-200 cursor-pointer"
        onClick={navigateToManagers}
      >
        <h3 className="text-2xl font-bold flex items-center gap-x-2">
          <span> Managers </span> <FaArrowAltCircleRight />
        </h3>
      </button>
    </div>
  );
}
