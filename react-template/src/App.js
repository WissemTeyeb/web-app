import "./App.css";
import * as React from "react";

import SignIn from "./Component/SignIn/SignIn";
import PrivateRoute from "./Component/PrivateRoute.js";
import PublicRoute from "./Component/PublicRoute.js";
import { Switch } from "react-router"; // react-router v4/v5

import { ConnectedRouter } from "connected-react-router";
import Home from "./Component/Home";

function App({ history }) {
  console.log("aaaa");

  return (
    <ConnectedRouter history={history}>
      <Switch>
        <PrivateRoute exact path="/" component={Home} />
        <PublicRoute path="/signIn" component={SignIn} />

        <PrivateRoute component={Home} path="/home" />
      </Switch>
    </ConnectedRouter>
  );
}
export default App;
