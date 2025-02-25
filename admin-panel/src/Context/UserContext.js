import { useState } from "react";



export const UserContext = () => {
    // eslint-disable-next-line no-unused-vars
    const [admin , setAdmin] = useState();
    return {admin};
}