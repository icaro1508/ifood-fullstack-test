import React, { useReducer } from 'react';
import { AppContext } from 'context/AppContext'
import './App.css';

import { initialState, reducer } from 'context/AppContext'

import Orders from 'components/Orders';

function App() {

  const [state, dispatch] = useReducer(reducer, initialState)

  return (
    <AppContext.Provider value={{ state, dispatch }}>
      <Orders />
    </AppContext.Provider>
  );
}

export default App;
