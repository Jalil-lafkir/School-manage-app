/* eslint-disable react/prop-types */
import { useState } from "react";

const GlobalCard = ({ onClose, title, message, fetchObjectInfo }) => {
  const [entityId, setEntityId] = useState("");
  const [objectInfo, setObjectInfo] = useState(null);

  const handleFetchInfo = async () => {
    const info = await fetchObjectInfo(entityId);
    setObjectInfo(info);
  };

  return (
    <div className=" top-0 right-0 left-0 z-50 flex justify-center items-center w-full max-h-[35rem] overflow-auto bg-opacity-50">
      <div className="relative p-4 w-full max-w-md bg-white rounded-lg shadow-sm dark:bg-gray-700">
        <button
          type="button"
          className="absolute top-3 right-3 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 dark:hover:bg-gray-600 dark:hover:text-white"
          onClick={onClose}
        >
          <svg
            className="w-3 h-3"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 14 14"
          >
            <path
              stroke="currentColor"
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth="2"
              d="M1 1l6 6m0 0l6 6M7 7l6-6M7 7L1 13"
            />
          </svg>
          <span className="sr-only">Close modal</span>
        </button>
        <div className="p-4 text-center">
          <h3 className="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">
            {title}
          </h3>
          <p className="mb-5 text-sm text-gray-500 dark:text-gray-300">
            {message}
          </p>
          <input
            type="text"
            className="mb-5 p-2 border border-gray-300 rounded-lg w-full dark:bg-gray-800 dark:border-gray-600 dark:text-white"
            placeholder="Enter entity ID"
            value={entityId}
            onChange={(e) => setEntityId(e.target.value)}
          />
          <button
            type="button"
            className="text-white bg-blue-600 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 font-medium rounded-lg text-sm px-5 py-2.5"
            onClick={handleFetchInfo}
          >
            Fetch Info
          </button>
          {objectInfo && (
            <div className="mt-5 text-left max-h-[10rem] overflow-auto">
              <h4 className="text-lg font-semibold text-white">
                Object Information:
              </h4>
              <pre className="text-sm text-gray-700 min-h-[3rem] dark:text-gray-300">
                {JSON.stringify(objectInfo, null, 2)}
              </pre>
            </div>
          )}
          <button
            type="button"
            className="py-2.5 px-5 ml-4 mt-3 text-sm font-medium text-gray-900 focus:outline-none bg-white rounded-lg border border-gray-200 hover:bg-gray-100 hover:text-blue-700 focus:ring-4 focus:ring-gray-100 dark:focus:ring-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:border-gray-600 dark:hover:text-white dark:hover:bg-gray-700"
            onClick={onClose}
          >
            Close
          </button>
        </div>
      </div>
    </div>
  );
};

export default GlobalCard;
