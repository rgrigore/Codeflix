import React, {useContext, useEffect, useState} from 'react';
import { Button } from "react-bootstrap";

import { UserContext } from "../UserContext"
import axios from "axios";
import VideosContainer from "../video/VideosContainer";

const apiUrl = "http://localhost:8762";

function HomePage() {
	const userContext = useContext(UserContext);

	const [videos, setVideos] = useState([]);

	const getVideos = () => {
		axios.get(
			`${apiUrl}/videos/all`,
			{headers: { Authorization: `Bearer ${userContext.jwt}` }}
		)
			.then(response => setVideos(response.data.videos))
			.catch(err => console.log(err));
	}

	useEffect(() => {
		getVideos();
		// eslint-disable-next-line
	}, []);

	return (
		<div>
			{ (userContext.jwt &&
				<Button className="m-2" onClick={() => {localStorage.clear(); window.location.reload()}}>{userContext.name}</Button>)// ||
				// <Login>login</Login>
			}

			<VideosContainer videos={videos} />
		</div>
	);
}

export default HomePage;