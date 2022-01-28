import React, { Component } from "react";
import "../../css/styles.css";
import CustomInput from "../CustomInput";
import Button from "../Button";
import { connect } from "react-redux";
import { signIn_action } from "./actions";
const mapDispatchToProps = (dispatch) => {
  return {
    signIn: (request) => {
      dispatch(signIn_action(request));
    },
  };
};

class SignIn extends Component {
  state = {
    email: "",
    password: "",
  };

  handleChange = (e) => {
    this.setState({ [e.currentTarget.id]: e.currentTarget.value });
  };
  handleClick = (e) => {
    e.preventDefault();

    this.props.signIn(this.state);
  };

  render() {
    console.log("again");
    return (
      <div className="App">
        <form className="form">
          <CustomInput
            labelText="Email"
            id="email"
            formControlProps={{
              fullWidth: true,
            }}
            handleChange={this.handleChange}
            type="text"
          />
          <CustomInput
            labelText="Password"
            id="password"
            formControlProps={{
              fullWidth: true,
            }}
            handleChange={this.handleChange}
            type="password"
          />

          <Button
            type="button"
            color="primary"
            className="form__custom-button"
            onClick={this.handleClick}
          >
            Log in
          </Button>
        </form>
      </div>
    );
  }
}
export default connect(null, mapDispatchToProps)(SignIn);
