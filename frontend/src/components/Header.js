import React, {useContext, useState} from 'react';
import {Link} from "react-router-dom";
import netflix_logo from "../images/netflix-logo-png-transparent.png";
import {Button} from "react-bootstrap";
import Login from "./authentication/Login";
import {UserContext} from "./UserContext";
import Register from "./authentication/Register";

function Header() {

	const userContext = useContext(UserContext);

	const [isLoginForm, setIsLoginForm] = useState(true);

	return (
		<>
			<Link to={"/home"}>
				<img alt={"logo"} src={netflix_logo} style={{
					height: 'auto',
					maxHeight: '250px',
					width: 'auto',
					maxWidth: '250px'
				}} />
			</Link>
			{ (userContext.jwt &&
				<div>
					<Button className="m-2" onClick={() => {localStorage.clear(); window.location.reload()}}>{userContext.name}</Button>
				</div>
			) || ( isLoginForm &&
				<Login switchAuthentication={() => setIsLoginForm(false)} />
			) ||
				<Register switchAuthentication={() => setIsLoginForm(true)} />
			}
		</>
	);
}

export default Header;