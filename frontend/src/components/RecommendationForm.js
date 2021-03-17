import React, {useState} from 'react';
import PropTypes from 'prop-types';
import ReactStars from "react-rating-stars-component";
import {Button} from "react-bootstrap";
import axios from "axios";

const apiUrl = "http://localhost:8762";

RecommendationForm.propTypes = {
	videoId: PropTypes.number.isRequired,
	recCallback: PropTypes.func.isRequired
};

function RecommendationForm(props) {

	const [rating, setRating] = useState(0);
	const [comment, setComment] = useState("");

	const postRecommendation = () => {
		axios.post(
			`${apiUrl}/videos/${props.videoId}/addrecommendation`,
			{
				rating: rating,
				comment: comment,
				videoId: props.videoId
			},
			{headers: { Authorization: `Bearer ${props.token}` }}
		).then(() => {
			document.getElementById("comment-input").value = "";
			props.recCallback();
		}).catch(err => console.log(err));
	}

	return (
		<div className="row justify-content-md-center p-5">
			<div className="col-md-auto">
				<input type="text" className="comment" id="comment-input" aria-describedby="comment"
				       placeholder="comment" style={{ minWidth: "400px" }} onBlur={ev => setComment(ev.target.value)} />
			</div>
			<div className="col col-sm-2">
				<ReactStars
					count={5}
					onChange={setRating}
					size={24}
					activeColor="#ffd700"
				/>
			</div>
			<div className="col col-sm-2">
				<Button onClick={postRecommendation}>Add</Button>
			</div>
		</div>
	);
}

export default RecommendationForm;