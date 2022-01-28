import React from 'react';
import { connect } from 'react-redux'
import { test_saga_action } from './actions'
import { Button } from '@material-ui/core';


const mapDispatchToProps = dispatch => {
    return {
        testSaga: () => {
            dispatch(test_saga_action());
        }
    };
};


const SagaComponent = ({ testSaga }) => {

    return (
        <Button variant="contained" onClick={testSaga}>Saga-Test</Button>

    )
}
export default connect(
    null,
    mapDispatchToProps
)(SagaComponent);
