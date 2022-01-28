import React from "react";
import { connect } from "react-redux";
import { testThunk } from "./api";
import { Button } from "@material-ui/core";

const mapDispatchToProps = (dispatch) => {
  return {
    testThunk: () => {
      dispatch(testThunk());
    },
  };
};
const ThunkComponet = ({ testThunk }) => {
  return (
    <Button variant="contained" onClick={testThunk}>
      Thunk-Test-8
    </Button>
  );
};
export default connect(null, mapDispatchToProps)(ThunkComponet);
