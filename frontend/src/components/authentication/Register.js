import React, {useContext, useState} from 'react';
import PropTypes from "prop-types";
import {Button, Alert} from "react-bootstrap";
import {UserContext} from "../UserContext";
import axios from "axios";

const apiUrl = "http://localhost:8762";

Register.propTypes = {
	switchAuthentication: PropTypes.func.isRequired
}

function Register(props) {

	const userContext = useContext(UserContext);

	const [username, setUsername] = useState("");
	const [password, setPassword] = useState("");
	const [success, setSuccess] = useState(false);
	const [error, setError] = useState(false);

	const submit = () => {
		axios.post(
			`${apiUrl}/account/register`,
			{
				username: username,
				password: password
			}
		).then(response => { // TODO Might need renaming
			// userContext.setId(response.data.id);
			// userContext.setName(response.data.username);
			// userContext.setRoles(response.data.roles);
			// userContext.setJwt(response.data.token);
			setSuccess(true);
		}).catch(err => {console.log(err); setError(true);});
	}

	return (
		<div className="inner-container pt-2">
			<div className="box">
				<input type="text" name="username" className="mr-1" placeholder="Username"
				       onBlur={event => setUsername(event.target.value)}/>
				<input type="password" name="password" className="ml-1" placeholder="Password"
				       onBlur={event => setPassword(event.target.value)}/><br/>

				<Button type="button" className="mt-2" onClick={submit}>Register</Button><br/>
				<Button variant={"link"} onClick={props.switchAuthentication}>Already have an account? Login</Button>
				{ (success &&
					<div className={'p-2'}>
						<Alert variant={"success"} style={{maxWidth: "300px", marginLeft: "470px"}}>
							Account created!
						</Alert>
					</div>
				)}
				{ (error &&
					<div className={'p-2'}>
						<Alert variant={"danger"} style={{maxWidth: "300px", marginLeft: "470px"}}>
							Registration failed!
						</Alert>
					</div>
				)}
			</div>
		</div>
	);
}

export default Register;