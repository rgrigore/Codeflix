import React, {useContext, useEffect, useState} from 'react';
import { UserContext } from "../UserContext"
import axios from "axios";
import VideosContainer from "../video/VideosContainer";
import {Button} from "react-bootstrap";

const apiUrl = "http://localhost:8762";

function HomePage() {
	const userContext = useContext(UserContext);

	const [videos, setVideos] = useState([]);
	const [newVideoTitle, setNewVideoTitle] = useState("");
	const [newVideoUrl, setNewVideoUrl] = useState("");

	const getVideos = () => {
		axios.get(
			`${apiUrl}/videos/all`,
			{headers: { Authorization: `Bearer ${userContext.jwt}` }}
		)
			.then(response => setVideos(response.data.videos))
			.catch(err => console.log(err));
	}

	const postVideo = () => {
		axios.post(
			`${apiUrl}/videos/add`,
			{
				title: newVideoTitle,
				url: newVideoUrl
			},
			{headers: { Authorization: `Bearer ${userContext.jwt}` }}
		)
			.then(() => getVideos())
			.catch(err => console.log(err));
	}

	useEffect(() => {
		getVideos();
		// eslint-disable-next-line
	}, [userContext.jwt]);

	return (
		<div>
			{ userContext.roles.includes("ROLE_ADMIN") &&
				<div className="inner-container mt-3">
					<div className="box">
						<input type="text" name="title" className="mr-1" placeholder="title"
						       onBlur={event => setNewVideoTitle(event.target.value)} />
						<input type="text" name="url" className="ml-1" placeholder="url"
						       onBlur={event => setNewVideoUrl(event.target.value)} />

						<Button type="button" className="ml-2" onClick={postVideo}>Post</Button>
					</div>
				</div>
			}
			<VideosContainer videos={videos} videoCallback={getVideos} />
		</div>
	);
}

export default HomePage;