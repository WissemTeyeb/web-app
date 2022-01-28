export function sagaReducer(state = { data: "Not Requested" }, action) {
  switch (action.type) {
    case "SAGA/TEST_SAGA_LOADING":
      return { data: "Loading" };
    case "SAGA/TEST_SAGA_RESULT":
      return { data: action.payload };
    default:
      return state;
  }
}
