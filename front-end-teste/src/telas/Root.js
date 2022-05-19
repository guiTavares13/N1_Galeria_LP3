
import React, { Component } from 'react';
import { Router } from 'react-router';
import { Redirect, Route, Switch } from 'react-router-dom';

import ScreensUserList from './User/List';

const ScreensRoot = () => (
  <Router>
    <Switch>
      <Route path="/user/list" component={ScreensUserList} />
    </Switch>
  </Router>
);

export default ScreensRoot;