import axios from "axios";
import * as actions from "./actions";

/*A thunk is just a function which delays the evaluation of the value.

The thunk function doesn’t take any arguments and gives the value whenever you invoke the thunk.

The word “Thunk” may seem vague at first but to put in amazingly simple terms, Thunk is just a function returned from another function.

Thunk est un concept de programmation dans lequel une fonction est utilisée pour retarder l'évaluation/le calcul d'une opération.
*/

export const testThunk = () => {
  return (dispatch) => {
    dispatch(actions.test_thunk_action());
    axios
      .get(`https://testing.googleapis.com/$discovery/rest?version=v1`)
      .then((res) => {
        dispatch(actions.test_thunk_succeed_action(res.data));
      })
      .catch((err) => {
        dispatch(actions.test_thunk_failed_action());
      });
  };
};

/*
Redux Thunk is a middleware that allows you to call the action creators that return a function(thunk) 
which takes the store’s dispatch method as the argument and which is afterwards used
 to dispatch the synchronous action after the API or side effects has been finished.
*/
/*
In the above example, testThunk() is an action creator which returns a function which in turn takes dispatch method as the argument.
 After we have received the cartItems from the server, we will dispatch a regular synchronous action using the dispatch method.

*/
