import React from 'react';
import PropTypes from 'prop-types';
import ReactStars from "react-rating-stars-component";
import { ListGroup } from "react-bootstrap";

RecommendationItem.propTypes = {
	recommendation: PropTypes.object.isRequired
};

function RecommendationItem(props) {
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
			</ListGroup>
		</ListGroup.Item>
	);
}

export default RecommendationItem;