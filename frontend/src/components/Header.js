import React from 'react';
import {Link} from "react-router-dom";

import netflix_logo from "../images/netflix-logo-png-transparent.png";

function Header() {
	return (
		<Link to={"/home"}>
			<img alt={"logo"} src={netflix_logo} style={{
				height: 'auto',
				maxHeight: '170px',
				width: 'auto',
				maxWidth: '170px'
			}} />
		</Link>
	);
}

export default Header;