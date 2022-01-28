import { thunkReducer } from "./Component/Redux-thunk-component/reducer";
import { sagaReducer } from "./Component/Redux-saga-component/reducer";
import { signInReducer } from "./Component/SignIn/reducer";

import { createStore, combineReducers, applyMiddleware } from "redux";
import thunk from "redux-thunk";

import createSagaMiddleware from "redux-saga";
import rootSaga from "./saga";
import { composeWithDevTools } from "redux-devtools-extension";
import { createBrowserHistory } from "history";
import { connectRouter } from "connected-react-router";
import { routerMiddleware } from "connected-react-router";

export const history = createBrowserHistory({
  /* pass a configuration object here if needed */
});
const middleware = routerMiddleware(history);
// Create a Redux store holding the state of your app.
// Its API is { subscribe, dispatch, getState }.

const sagaMiddleware = createSagaMiddleware();
const reducer = combineReducers({
  thunk: thunkReducer,
  saga: sagaReducer,
  signIn: signInReducer,
  router: connectRouter(history),
});

// applyMiddleware supercharges createStore with middleware:
const store = createStore(
  reducer,
  composeWithDevTools(applyMiddleware(middleware, thunk, sagaMiddleware))
);

// This would produce the following state object
sagaMiddleware.run(rootSaga);

export default store;
