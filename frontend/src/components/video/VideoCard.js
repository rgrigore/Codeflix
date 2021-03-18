import React, {useContext} from 'react';
import PropTypes from 'prop-types';
import { Link } from "react-router-dom";
import {Button, Card} from "react-bootstrap";
import axios from "axios";
import {UserContext} from "../UserContext";

const apiUrl = "http://localhost:8762";

VideoCard.propTypes = {
	video: PropTypes.object.isRequired,
	videoCallback: PropTypes.func.isRequired
};

const imgStyle = {
	height: 'auto',
	maxHeight: '270px',
	width: 'auto',
	maxWidth: '270px'
};

function VideoCard(props) {

	const userContext = useContext(UserContext);

	const remove = () => {
		axios.delete(
			`${apiUrl}/videos/${props.video.id}/delete`,
			{headers: { Authorization: `Bearer ${userContext.jwt}` }}
		)
			.then(() => props.videoCallback())
			.catch(err => console.log(err));
	}

	return (
		<Link to={`/video/${props.video.id}`}>
			<Card className="d-flex bg-danger text-black p-1">
				<Card.Body>
					<Card.Title>{props.video.name}</Card.Title>
					{ userContext.roles.includes("ROLE_ADMIN") &&
						<Button variant={"danger"} onClick={remove}>X</Button>
					}
				</Card.Body>
				<Card.Img variant={"bottom"} src={`http://img.youtube.com/vi/${props.video.url}/hqdefault.jpg`} style={imgStyle} />
			</Card>
		</Link>
	);
}

export default VideoCard;