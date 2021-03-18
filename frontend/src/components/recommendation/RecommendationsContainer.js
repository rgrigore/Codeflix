import React from 'react';
import PropTypes from 'prop-types';
import { ListGroup } from "react-bootstrap";
import RecommendationItem from "./RecommendationItem";

RecommendationsContainer.propTypes = {
	recommendations: PropTypes.array.isRequired,
	recCallback: PropTypes.func.isRequired
};

function RecommendationsContainer(props) {
	return (
		<ListGroup className='m-5'>
			{props.recommendations.map((rec, i) =>
				<RecommendationItem recommendation={rec} recCallback={props.recCallback} key={i} />
			)}
		</ListGroup>
	);
}

export default RecommendationsContainer;