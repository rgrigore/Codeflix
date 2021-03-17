import React from 'react';
import PropTypes from 'prop-types';
import { ListGroup } from "react-bootstrap";
import RecommendationItem from "./RecommendationItem";

RecommendationsContainer.propTypes = {
	recommendations: PropTypes.array.isRequired
};

function RecommendationsContainer(props) {
	return (
		<ListGroup className='m-5'>
			{props.recommendations.map((rec, i) =>
				<RecommendationItem recommendation={rec} key={i} />
			)}
		</ListGroup>
	);
}

export default RecommendationsContainer;