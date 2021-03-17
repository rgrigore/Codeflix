import React from 'react';
import PropTypes from 'prop-types';
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";

VideoCard.propTypes = {
	video: PropTypes.object.isRequired
};

const imgStyle = {
	height: 'auto',
	maxHeight: '270px',
	width: 'auto',
	maxWidth: '270px'
};

function VideoCard(props) {
	return (
		<Link to={`/video/${props.video.id}`}>
			<Card className="d-flex bg-danger text-black p-1">
				<Card.Body>
					<Card.Title>{props.video.name}</Card.Title>
				</Card.Body>
				<Card.Img variant={"bottom"} src={`http://img.youtube.com/vi/${props.video.url}/hqdefault.jpg`} style={imgStyle} />
			</Card>
		</Link>
	);
}

export default VideoCard;