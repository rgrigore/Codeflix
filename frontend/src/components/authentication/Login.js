import React, {useContext, useState} from 'react';
import PropTypes from "prop-types";
import {Button} from "react-bootstrap";
import axios from "axios";
import {UserContext} from "../UserContext";

const apiUrl = "http://localhost:8762";

Login.propTypes = {
	switchAuthentication: PropTypes.func.isRequired
}

function Login(props) {

	const userContext = useContext(UserContext);

	const [username, setUsername] = useState("");
	const [password, setPassword] = useState("");

	const submit = () => {
		axios.post(
			`${apiUrl}/account/login`,
			{
				username: username,
				password: password
			}
		).then(response => { // TODO Might need renaming
			// userContext.setId(response.data.id);
			userContext.setName(response.data.username);
			userContext.setJwt(response.data.token);
		}).catch(err => console.log(err));
	}

	return (
		<div className="inner-container pt-2">
			<div className="box">
				<input type="text" name="username" className="mr-1" placeholder="Username"
				       onBlur={event => setUsername(event.target.value)}/>
				<input type="password" name="password" className="ml-1" placeholder="Password"
				       onBlur={event => setPassword(event.target.value)}/><br/>

				<Button type="button" className="mt-2" onClick={submit}>Login</Button><br/>
				<Button variant={"link"} onClick={props.switchAuthentication}>Don't have an account? Register</Button>
			</div>
		</div>
	);
}

export default Login;