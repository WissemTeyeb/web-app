export const signin_resquest = "SIGNIN/SIGNIN_LOADING";
export const signIn_succeed = "SIGNIN/SIGNIN_SUCCEED";
export const signin_failed = "SIGNIN/SIGNIN__FAILED";
export const logout = "SIGNOUT/SIGNOUT";
export const logout_succeed = "SIGNOUT/SIGNOUT_SUCCEED";

export const signIn_action = (request) => {
  return {
    type: signin_resquest,
    payload: request,
  };
};
export const signOut_action = () => {
  return {
    type: logout,
  };
};

export const signOut_result_action = () => {
  return {
    type: logout_succeed,
  };
};
export const signIn_succeed_action = (data) => {
  return {
    type: signIn_succeed,
    payload: "Ok",
  };
};
export const test_saga_failed_action = (errorMessage) => {
  return {
    type: signin_failed,
    payload: errorMessage,
  };
};
