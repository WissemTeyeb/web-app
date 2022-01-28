import { all } from "redux-saga/effects";
import { actionWatcher } from "./Component/Redux-saga-component/api";
import { signInWatcher } from "./Component/SignIn/api";

export default function* rootSaga() {
  yield all([actionWatcher(), signInWatcher()]);
}
