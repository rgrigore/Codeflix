import React, {createContext, useState} from "react";

export const UserContext = createContext({
	id: -1,
	name: null,
	jwt: null,
	setId: () => {},
	setName: () => {},
	setJwt: () => {}
});

export function UserContextProvider(props) {
	const [id, setId] = useState(localStorage.getItem("userId") || -1);
	const [name, setName] = useState(localStorage.getItem("userName") || null);
	const [jwt, setJwt] = useState(localStorage.getItem("jwt") || null);

	const saveId = (id) => {
		setId(id);
		localStorage.setItem("userId", id);
	}
	const saveName = (name) => {
		setName(name);
		localStorage.setItem("userName", name);
	}
	const saveJwt = (jwt) => {
		setJwt(jwt);
		localStorage.setItem("jwt", jwt);
	}

	return (
		<UserContext.Provider value={{
			id: id, name: name, jwt: jwt,
			setId: saveId, setName: saveName, setJwt: saveJwt
		}}>
			{props.children}
		</UserContext.Provider>
	);
}