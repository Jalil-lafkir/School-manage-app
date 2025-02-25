/* eslint-disable react/prop-types */
import { useState, useEffect } from "react";
import axios from "axios";

const entityFields = {
  Student: {
    id: "",
    name: "",
    email: "",
    finalGarde: "", // Corrected field name
    student_modules: [
      {
        id: "M001",
        name: "Sample Module",
        description: "Sample Description",
        coefficient: 1,
        FirstExame: 0,
        SecondExame: 0,
        ContinuousMonitoring: 0,
      },
    ],
  },
  Session: {
    id: "",
    name: "",
    date: "",
    time: "",
    roomId: "",
    professorId: "",
    moduleId: "",
    sessionStudents: [
      {
        id: "S001",
        name: "Sample Student",
        email: "sample@student.com",
        finalGarde: 0,
      },
    ],
  },
  Room: {
    id: "",
    name: "",
    type: "",
  },
  Professor: {
    id: "",
    name: "",
    email: "",
    mountSalary: "",
    professor_sessions: [
      {
        id: "S001",
        name: "Sample Session",
        date: "2025-01-01",
        time: "10:00",
        roomId: "R001",
        professorId: "P001",
        moduleId: "M001",
      },
    ],
  },
  Module: {
    id: "",
    name: "",
    description: "",
    coefficient: "",
    firstExame: "",
    secondExame: "",
    continuousMonitoring: "",
  },
};

const GlobalEditForm = ({ entityName }) => {
  const [formData, setFormData] = useState({});
  const [nestedData, setNestedData] = useState({});

  useEffect(() => {
    if (entityName) {
      const initialData = entityFields[entityName] || {};
      // Ensure placeholder row for nested objects with fake data
      Object.keys(initialData).forEach((key) => {
        if (Array.isArray(initialData[key]) && initialData[key].length === 0) {
          initialData[key] = [{}];
        }
      });
      setFormData(initialData);
    }
  }, [entityName]);

  useEffect(() => {
    const fetchNestedData = async () => {
      if (entityName) {
        const nestedKeys = Object.keys(entityFields[entityName]).filter((key) =>
          Array.isArray(entityFields[entityName][key])
        );

        for (const key of nestedKeys) {
          try {
            let nestedObject = key.toLowerCase();
            if (entityName === "Student" && key === "student_modules") {
              nestedObject = "module";
            } else if (
              entityName === "Professor" &&
              key === "professor_sessions"
            ) {
              nestedObject = "session";
            } else if (entityName === "Session" && key === "sessionStudents") {
              nestedObject = "student";
            }

            const response = await axios.get(
              `http://localhost:8080/app/rest/${nestedObject}`
            );
            if (response.data && response.data.objects) {
              console.log(`Fetched ${key}:`, response.data.objects);
              setNestedData((prev) => ({
                ...prev,
                [key]: response.data.objects,
              }));
              setFormData((prev) => ({
                ...prev,
                [key]: response.data.objects,
              }));
            }
          } catch (error) {
            console.error(`Failed to fetch ${key}:`, error);
          }
        }
      }
    };

    fetchNestedData();
  }, [entityName]);

  useEffect(() => {
    const fetchEntityDataById = async () => {
      if (formData.id) {
        try {
          const response = await axios.get(
            `http://localhost:8080/app/rest/${entityName.toLowerCase()}/1?token=${
              formData.id
            }`,
            {
              headers: {
                "Content-Type": "application/json",
              },
            }
          );

          const fetchedData = response.data.object;
          console.log(fetchedData);
          // Ensure placeholder row for nested objects with fake data
          if (entityName !== "Room " || entityName !== "Module") {
            Object.keys(fetchedData).forEach((key) => {
              if (
                Array.isArray(fetchedData[key]) &&
                fetchedData[key].length === 0
              ) {
                const sampleRow = Object.keys(
                  entityFields[entityName][key][0] || {}
                ).reduce((acc, field) => {
                  acc[field] = "";
                  return acc;
                }, {});
                fetchedData[key] = [sampleRow];
              }
            });
          }

          setFormData(fetchedData);
        } catch (error) {
          console.error("Failed to fetch entity data:", error);
        }
      }
    };

    fetchEntityDataById();
  }, [entityName, formData.id]);

  const handleChange = (e, parentKey = null, index = null, field = null) => {
    if (parentKey && index !== null) {
      // Update nested object (array of objects)
      setFormData((prev) => ({
        ...prev,
        [parentKey]: prev[parentKey].map((item, i) =>
          i === index ? { ...item, [field]: e.target.value } : item
        ),
      }));
      setNestedData((prev) => ({
        ...prev,
        [parentKey]: prev[parentKey].map((item, i) =>
          i === index ? { ...item, [field]: e.target.value } : item
        ),
      }));
    } else {
      setFormData({ ...formData, [e.target.name]: e.target.value });
    }
  };

  const handleAddRow = (key) => {
    const newRow = Object.keys(formData[key][0] || {}).reduce((acc, field) => {
      acc[field] = "";
      return acc;
    }, {});

    setFormData((prev) => ({
      ...prev,
      [key]: [...prev[key], newRow],
    }));
  };

  const handleRemoveRow = (key, index) => {
    setFormData((prev) => ({
      ...prev,
      [key]: prev[key].filter((_, i) => i !== index),
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const requestData = {
      token: "your-token-here", // Replace with actual token
      object: formData,
    };
    try {
      const response = await axios.put(
        `http://localhost:8080/app/rest/${entityName.toLowerCase()}/`,
        requestData
      );
      console.log("Saved successfully:", response.data);
      alert("Saved successfully!");
      handleCloseForm();
    } catch (error) {
      console.error("Failed to save:", error);
    }
  };

  const handleCloseForm = () => {};

  return (
    <form
      className="w-[90%] mx-auto flex flex-col bg-gray-800 p-6 rounded-lg shadow-lg max-h-[35rem] overflow-y-auto"
      onSubmit={handleSubmit}
    >
      <div className="flex justify-between items-center mb-4">
        <h2 className="text-2xl font-semibold text-white">Edit Form</h2>
        <button
          type="button"
          onClick={handleCloseForm}
          className="text-white bg-red-600 hover:bg-red-700 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-4 py-2"
        >
          Close
        </button>
      </div>
      {entityName && (
        <div className="flex flex-col items-center justify-center">
          {/* Left Side: Main Entity Info */}
          <div className="w-full p-4 border-r border-gray-600">
            <h2 className="w-full font-semibold text-white mb-4">
              Entity Info
            </h2>
            {Object.keys(formData).map((key) => {
              if (Array.isArray(formData[key])) return null; // Skip arrays for now

              return (
                <div key={key} className="relative z-0 w-full mb-5 group">
                  <input
                    type="text"
                    name={key}
                    value={formData[key] || ""}
                    onChange={handleChange}
                    className="block py-2.5 px-0 w-full text-md text-white bg-transparent border-0 border-b-2 border-gray-500 focus:outline-none focus:border-blue-500 peer"
                    placeholder=" "
                  />
                  <label
                    htmlFor={key}
                    className="peer-placeholder-shown:translate-y-0 peer-focus:-translate-y-6 text-gray-400"
                  >
                    {key.charAt(0).toUpperCase() + key.slice(1)}
                  </label>
                </div>
              );
            })}
          </div>

          {/* Right Side: Nested Objects (Modules, Sessions, Students) */}
          <div className="w-full p-4 h-[18rem] overflow-y-auto">
            {Object.keys(nestedData).map((key) => {
              if (!Array.isArray(nestedData[key])) return null;

              return (
                <div key={key} className="mb-6 scroll-auto">
                  <h2 className="text-xl font-semibold text-white mb-4">
                    {key.toUpperCase()}
                  </h2>
                  <div className="max-h-[800px] overflow-y-auto">
                    <table className="w-full border border-gray-600 text-white">
                      <thead className="bg-gray-700 sticky top-0">
                        <tr>
                          {Object.keys(nestedData[key][0] || {}).map(
                            (field) => (
                              <th
                                key={field}
                                className="px-4 py-2 border border-gray-600"
                              >
                                {field.charAt(0).toUpperCase() + field.slice(1)}
                              </th>
                            )
                          )}
                          <th className="px-4 py-2 border border-gray-600">
                            Actions
                          </th>
                        </tr>
                      </thead>
                      <tbody>
                        {formData[key].map((item, index) => (
                          <tr key={index} className="border border-gray-600">
                            {Object.keys(item).map((field) => (
                              <td
                                key={field}
                                className="px-4 py-2 border border-gray-600"
                              >
                                <input
                                  type="text"
                                  name={field}
                                  value={item[field] || ""}
                                  onChange={(e) =>
                                    handleChange(e, key, index, field)
                                  }
                                  className="w-full bg-transparent text-white border-0 focus:outline-none"
                                />
                              </td>
                            ))}
                            <td className="px-4 py-2 border border-gray-600">
                              <button
                                type="button"
                                onClick={() => handleRemoveRow(key, index)}
                                className="text-red-500"
                              >
                                Remove
                              </button>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                    <button
                      type="button"
                      onClick={() => handleAddRow(key)}
                      className="mt-2 text-blue-500"
                    >
                      Add Row
                    </button>
                  </div>
                </div>
              );
            })}
          </div>
        </div>
      )}
      {/* Submit Button (Full Width) */}
      <div className="w-full flex justify-center mt-6">
        <button
          type="submit"
          className="text-white w-40 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
        >
          Submit
        </button>
      </div>
    </form>
  );
};

export default GlobalEditForm;
