export function signInReducer(state = { signIn: false, message: "" }, action) {
  switch (action.type) {
    case "SIGNIN/SIGNIN_LOADING":
      return { ...state, signIn: false, message: "OK" };
    case "SIGNIN/SIGNIN_SUCCEED":
      return { ...state, signIn: true, message: "OK" };
    case "SIGNIN/SIGNIN__FAILED":
      return { ...state, signIn: false, message: action.payload };
    case "SIGNOUT/SIGNOUT_SUCCEED":
      return { ...state, signIn: false };

    default:
      return state;
  }
}
