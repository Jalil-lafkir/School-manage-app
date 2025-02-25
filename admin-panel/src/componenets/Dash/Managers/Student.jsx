import GlobalCard from "../DataDisplayCom/GlobalCard";
import GlobalAddForm from "../DataDisplayCom/GlobalAddForm";
import GlobalEditForm from "../DataDisplayCom/GlobalEditForm";
import GlobalDialog from "../DataDisplayCom/GlobalDialog";
import GlobalTable from "../DataDisplayCom/GlobalTable";
import { useState, useEffect } from "react";
import axios from "axios";

const Student = () => {
  const [showAll, setShowAll] = useState(false);
  const [showProfile, setShowProfile] = useState(false);
  const [addNew, setAddNew] = useState(false);
  const [edit, setEdit] = useState(false);
  const [deleteStudent, setDeleteStudent] = useState(false);
  const [students, setStudents] = useState(null);

  const handleConfirm = ({ entityId }) => {
    axios
      .delete(`http://localhost:8080/app/rest/student/`, {
        data: {
          object: {
            id: entityId,
          },
        },
      })
      .then(() => {
        setStudents(students.filter((student) => student.id !== entityId));
        alert("Student deleted successfully!");
        setDeleteStudent(false);
      })
      .catch((error) => {
        alert("Error: " + error);
      });
  };

  const handleCancel = () => {
    console.log("Cancelled action!");
    setDeleteStudent(false);
  };

  const handleCloseCard = () => {
    showProfile(!showProfile);
  };

  const fetchObjectInfo = async (entityId) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/app/rest/student/1?token=${entityId}`,
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );

      if (response.data.object != null) {
        return response.data.message;
      }
    } catch (error) {
      console.error("Failed to fetch entity data:", error);
    }
  };

  const columns = [
    { key: "id", label: "ID" },
    { key: "name", label: "Name" },
    { key: "email", label: "Email" },
    { key: "finalGarde", label: "Final Grade" },
    { key: "student_modules", label: "Modules" },
  ];

  useEffect(() => {
    axios
      .get("http://localhost:8080/app/rest/student/")
      .then((response) => {
        setStudents(response.data.objects);
        console.log(response.data.objects);
      })
      .catch((error) => {
        alert("Error: " + error);
      });
  }, []);

  return (
    <div className="w-full h-full py-4 flex flex-col items-center justify-center gap-y-3">
      <div className=" w-[80%] h-40  flex items-center justify-between px-4">
        <button
          onClick={() => {
            setShowAll(!showAll);
          }}
          type="button"
          className="text-white h-13 bg-gradient-to-br from-purple-600 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 w-60 font-medium rounded-lg text-md px-5 py-2.5 text-center me-2 mb-2"
        >
          Show All Studnet
        </button>
        <button
          onClick={() => {
            setShowProfile(!showProfile);
          }}
          type="button"
          className="text-white h-13 bg-gradient-to-br from-purple-600 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 w-60 font-medium rounded-lg text-md px-5 py-2.5 text-center me-2 mb-2"
        >
          Show Student Profile
        </button>
        <button
          onClick={() => {
            setAddNew(!addNew);
          }}
          type="button"
          className="text-white h-13 bg-gradient-to-br from-purple-600 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 w-60 font-medium rounded-lg text-md px-5 py-2.5 text-center me-2 mb-2"
        >
          Add new Student
        </button>
        <button
          onClick={() => {
            setEdit(!edit);
          }}
          type="button"
          className="text-white h-13 bg-gradient-to-br from-purple-600 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 w-60 font-medium rounded-lg text-md px-5 py-2.5 text-center me-2 mb-2"
        >
          Edite Existing
        </button>
        <button
          onClick={() => {
            setDeleteStudent(!deleteStudent);
          }}
          type="button"
          className="text-white h-13 bg-gradient-to-br from-purple-600 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 w-60 font-medium rounded-lg text-md px-5 py-2.5 text-center me-2 mb-2"
        >
          Delete Student
        </button>
      </div>
      <div className=" w-[80%] h-150  flex items-center justify-center px-4">
        {showAll && <GlobalTable columns={columns} data={students} />}
        {showProfile && (
          <GlobalCard
            title="Object Information"
            message="Please enter the entity ID to fetch the object information."
            fetchObjectInfo={fetchObjectInfo}
            onClose={handleCloseCard}
          />
        )}
        {addNew && <GlobalAddForm entityName={"Student"} />}
        {edit && <GlobalEditForm entityName={"Student"} />}
        {deleteStudent && (
          <GlobalDialog
            isOpen={deleteStudent}
            onClose={() => setDeleteStudent(false)}
            title="Confirm Deletion"
            message="Are you sure you want to delete this item?"
            onConfirm={handleConfirm}
            onCancel={handleCancel}
            confirmText="Yes, Delete"
            cancelText="No, Keep It"
          />
        )}
      </div>
    </div>
  );
};

export default Student;
