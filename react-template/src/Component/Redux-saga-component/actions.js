export const test_saga_loading = "SAGA/TEST_SAGA_LOADING";
export const test_saga_succeed = "SAGA/TEST_SAGA_SUCCEED";
export const test_saga_failed = "SAGA/TEST_SAGA_FAILED";

export const test_saga_action = () => {
  return {
    type: test_saga_loading,
    payload: "Loading",
  };
};

export const test_saga_succeed_action = (data) => {
  return {
    type: test_saga_succeed,
    payload: data,
  };
};
export const test_saga_failed_action = () => {
  return {
    type: test_saga_failed,
    payload: "fail",
  };
};
