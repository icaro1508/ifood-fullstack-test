import React from 'react'

import { useReducer } from 'react';
import { AppContext, initialState, reducer } from 'context/AppContext'
import './App.css';

import Orders from 'components/Orders';

function App() {

  const [state, dispatch] = useReducer(reducer, initialState)
  console.log(process.env.NODE_ENV)
  return (
    <AppContext.Provider value={{ state, dispatch }}>
      <Orders />
    </AppContext.Provider>
  );
}

export default App;
