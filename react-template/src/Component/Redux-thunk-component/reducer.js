export function thunkReducer(state = { data: "Not Requested" }, action) {
  switch (action.type) {
    case "THUNK/TEST_THUNK_LOADING":
      return { data: "Loading" };
    case "THUNK/TEST_THUNK_RESULT":
      return { data: action.payload };
    default:
      return state;
  }
}
