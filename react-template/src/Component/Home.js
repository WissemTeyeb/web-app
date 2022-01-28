import React from "react";
import SagaComponent from "./Redux-saga-component/Redux-saga-component";
import ThunkComponet from "./Redux-thunk-component/Redux-thunk-component";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import { signOut_action } from "./SignIn/actions";
import { connect } from "react-redux";

const mapDispatchToProps = (dispatch) => {
  return {
    logOut: () => {
      dispatch(signOut_action());
    },
  };
};
const Home = ({ logOut }) => {
  return (
    <Box sx={{ flexGrow: 10 }}>
      <Grid container spacing={50}>
        <Grid item xs={12}>
          <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
              <Toolbar>
                <IconButton
                  size="large"
                  edge="start"
                  color="inherit"
                  aria-label="menu"
                  sx={{ mr: 2 }}
                >
                  <MenuIcon />
                </IconButton>
                <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                  Welcome
                </Typography>
                <Button color="inherit" onClick={logOut}>
                  Logout
                </Button>
              </Toolbar>
            </AppBar>
          </Box>
        </Grid>

        <Grid item xs={2}>
          <SagaComponent />
        </Grid>
        <Grid item xs={2}>
          <ThunkComponet />
        </Grid>
      </Grid>
    </Box>
  );
};
export default connect(null, mapDispatchToProps)(Home);
