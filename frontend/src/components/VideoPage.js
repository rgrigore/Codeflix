import React, {useContext, useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import axios from "axios";
import {UserContext} from "./UserContext";
import RecommendationsContainer from "./RecommendationsContainer";
import RecommendationForm from "./RecommendationForm";

const apiUrl = "http://localhost:8762";

function VideoPage() {

	const {id} = useParams();
	const userContext = useContext(UserContext);

	const [video, setVideo] = useState({ id: -1, title: "missing title", url: null });
	const [recommendations, setRecommendations] = useState([]);

	const getVideo = () => {
		axios.get(
			`${apiUrl}/videos/${id}`,
			{headers: { Authorization: `Bearer ${userContext.jwt}` }}
		).then(response => {
			setVideo(response.data.video);
			setRecommendations(response.data.recommendations);
		}).catch(err => console.log(err));
	}

	useEffect(() => {
		getVideo();
		// eslint-disable-next-line
	}, [])

	return (
		<div>
			<h3 style={{ color: '#00FFFF' }} className={'mt-5 mb-3'}>{video.title}</h3>
			<iframe title={video.title} width="1080" height="550" src={`https://www.youtube.com/embed/${video.url}`}
			        allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
			        frameBorder="2" allowFullScreen />
			<RecommendationsContainer recommendations={recommendations} />
			<RecommendationForm videoId={id} recCallback={getVideo} />
		</div>
	);
}

export default VideoPage;