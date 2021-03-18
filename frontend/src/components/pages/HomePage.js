import React, {useContext, useEffect, useState} from 'react';
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
			<VideosContainer videos={videos} videoCallback={getVideos} />
		</div>
	);
}

export default HomePage;