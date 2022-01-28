const test_thunk_loading = "THUNK/TEST_THUNK_LOADING";
const test_thunk_succeed = "THUNK/TEST_THUNK_SUCCEED";
const test_thunk_failed = "THUNK/TEST_THUNK_FAILED";

export const test_thunk_action = () => {
  return {
    type: test_thunk_loading,
    payload: "Loading",
  };
};
export const test_thunk_succeed_action = (data) => {
  return {
    type: test_thunk_succeed,
    payload: data,
  };
};
export const test_thunk_failed_action = (data) => {
  return {
    type: test_thunk_failed,
    payload: data,
  };
};
