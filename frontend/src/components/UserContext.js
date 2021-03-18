import React, {createContext, useState} from "react";

export const UserContext = createContext({
	id: -1,
	name: null,
	roles: [],
	jwt: null,
	setId: () => {},
	setName: () => {},
	setRoles: () => {},
	setJwt: () => {}
});

export function UserContextProvider(props) {
	const [id, setId] = useState(localStorage.getItem("userId") || -1);
	const [name, setName] = useState(localStorage.getItem("userName") || null);
	const [roles, setRoles] = useState(JSON.parse(localStorage.getItem("roles")) || [])
	const [jwt, setJwt] = useState(localStorage.getItem("jwt") || null);

	const saveId = id => {
		setId(id);
		localStorage.setItem("userId", id);
	}
	const saveName = name => {
		setName(name);
		localStorage.setItem("userName", name);
	}
	const saveRoles = roles => {
		setRoles(roles);
		localStorage.setItem("roles", JSON.stringify(roles));
	}
	const saveJwt = jwt => {
		setJwt(jwt);
		localStorage.setItem("jwt", jwt);
	}

	return (
		<UserContext.Provider value={{
			id: id, name: name, roles: roles, jwt: jwt,
			setId: saveId, setName: saveName, setRoles: saveRoles, setJwt: saveJwt
		}}>
			{props.children}
		</UserContext.Provider>
	);
}