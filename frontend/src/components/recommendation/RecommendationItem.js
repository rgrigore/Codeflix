import React, {useContext} from 'react';
import PropTypes from 'prop-types';
import ReactStars from "react-rating-stars-component";
import {Button, ListGroup} from "react-bootstrap";
import axios from "axios";
import {UserContext} from "../UserContext";

const apiUrl = "http://localhost:8762";

RecommendationItem.propTypes = {
	recommendation: PropTypes.object.isRequired,
	recCallback: PropTypes.func.isRequired
};

function RecommendationItem(props) {

	const userContext = useContext(UserContext);

	const remove = () => {
		axios.delete(
			`${apiUrl}/videos/recommendation/${props.recommendation.id}/delete`,
			{headers: { Authorization: `Bearer ${userContext.jwt}` }}
		)
			.then(() => props.recCallback)
			.catch(err => console.log(err));
	}

	return (
		<ListGroup.Item variant="info" className={"d-inline mb-2"} data-rec-id={props.recommendation.id}>
			<ListGroup horizontal className={'justify-content-center'}>
				<ListGroup.Item variant={"info"}>"{props.recommendation.comment}"</ListGroup.Item>
				<ListGroup.Item variant={"info"} className={''}>
					<ReactStars
						value={props.recommendation.rating}
						edit={false}
						activeColor="#ffd700"
					/>
				</ListGroup.Item>
				{ userContext.roles.includes("ROLE_ADMIN") &&
					<ListGroup.Item>
						<Button variant={"danger"} onClick={remove}>X</Button>
					</ListGroup.Item>
				}
			</ListGroup>
		</ListGroup.Item>
	);
}

export default RecommendationItem;