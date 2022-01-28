import axios from "axios";
import { put, takeLatest, call } from "redux-saga/effects";
import * as actions from "./actions";
import { push } from "react-router-redux";

//generator function which helps us to write asynchronous code.

/** function that returns an axios call */
function loginApi(authParams) {
  return axios.request({
    method: "post",
    url: "/url/api/auth/signin",
    data: authParams,
  });
}
function* logOutSaga() {
  localStorage.removeItem("user");
  yield put(actions.signOut_result_action());
  yield put(push("/signIn"));
}
/** saga worker that is responsible for the side effects */
function* loginEffectSaga(action) {
  try {
    // data is obtained after axios call is resolved
    let { data } = yield call(loginApi, action.payload);
    localStorage.setItem("user", { accessToken: data });

    // dispatch action to change redux state
    yield put(actions.signIn_succeed_action());
    // redirect to home route after successful login
    yield put(push("/home"));
  } catch (e) {
    // catch error on
    //yield put(actions.test_saga_failed_action(e.message));
    // alert using an alert library
  }
}

export function* signInWatcher() {
  yield takeLatest(actions.signin_resquest, loginEffectSaga);
  yield takeLatest(actions.logout, logOutSaga);
}
