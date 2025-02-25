import "react";
import { useState } from "react";

const AuthPanel = () => {
  const [Authuser, setAuthUser] = useState("");
  const [Authpassword, setAuthPassword] = useState("");
  const handleSubmit = (event) => {
    const user = "admin";
    const password = "1234";
    event.preventDefault();
    if (user === Authuser && password === Authpassword) {
      localStorage.setItem("admin", true);
      window.location.href = "/dashboard";
    }
  };
  const handleChange = (event) => {
    const { id, value } = event.target;
    id === "username" ? setAuthUser(value) : setAuthPassword(value);
    console.log(Authuser, Authpassword);
  };

  return (
    <form
      className="flex flex-col items-center absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2  bg-white w-[40rem] h-[30rem] border-2 border-solid border-[#5b5b5b] rounded-3xl "
      onSubmit={handleSubmit}
    >
      <div className="text-[23px] font-bold text-[#5B5B5B] text-center my-8">
        {" "}
        Admin Auth Panel{" "}
      </div>
      <input
        type="text"
        id="username"
        name="username"
        placeholder="username "
        className=" w-[80%] h-12 my-5 px-3 bg-[#F0F1F8] rounded-lg border-2 border-solid border-[#5b5b5b] text-[#5b5b5b]"
        onChange={handleChange}
      />
      <input
        type="password"
        id="password"
        name="password"
        placeholder="password "
        className=" w-[80%] h-12 my-3  px-3 bg-[#F0F1F8] rounded-lg border-2 border-solid border-[#5b5b5b] text-[#5b5b5b]"
        onChange={handleChange}
      />
      <input
        type="submit"
        value="View dashboard"
        className=" w-[80%] h-12 my-3  px-3  rounded-lg border-2 border-solid border-[#5b5b5b] bg-[#4d80e4] text-white"
      />
      <div className="text-[18px] font-semibold text-[#4d80e4] text-center my-12">
        <a href="mailto: support@administration.com">
          {" "}
          contact the administation{" "}
        </a>{" "}
      </div>
    </form>
  );
};

export default AuthPanel;
