import axios from "axios";
import { put, takeLatest, call } from "redux-saga/effects";
import * as actions from "./actions";

//generator function which helps us to write asynchronous code.
function* tesSaga(action) {
  try {
    const { data } = yield call(
      axios.get,
      "https://testing.googleapis.com/$discovery/rest?version=v1"
    );
    yield put(actions.test_saga_succeed_action(data));
  } catch (e) {
    yield put(actions.test_saga_failed_action());
  }
}

export function* actionWatcher() {
  yield takeLatest(actions.test_saga_loading, tesSaga);
}
