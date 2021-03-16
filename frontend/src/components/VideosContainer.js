import React from "react";
import PropTypes from "prop-types";
import { CardColumns } from "react-bootstrap";
import VideoCard from "./VideoCard";

VideosContainer.propTypes = {
	videos: PropTypes.array.isRequired
};

function VideosContainer(props) {
	return (
		<CardColumns className="d-flex m-5">
			{ props.videos.map((video, i) =>
				<VideoCard video={video} key={i} />
			)}
		</CardColumns>
	);
}

export default VideosContainer;