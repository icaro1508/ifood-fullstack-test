import React, { useCallback, useReducer } from 'react';
import { AppContext } from 'context/AppContext'
import './App.css';

import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'

import OrdersSearchForm from 'components/business//OrdersSearchForm';
import OrdersTable from 'components/business/OrdersTable';
import OrderDetailsModal from 'components/business/OrderDetailsModal';

import { initialState, reducer, actionCreators } from 'context/AppContext'

function App() {


  const [state, dispatch] = useReducer(reducer, initialState)

  function fetchOrders({ startDate, endDate, clientName, phone, email }) {
    console.log(startDate, endDate, clientName, phone, email)
  }

  const fetchOrdersWithFilters = useCallback(filters => {
    fetchOrders(filters)
  }, [])

  return (
    <AppContext.Provider value={{ state, dispatch, actionCreators }}>
      <Container>
        <Row>
          <Col>
            <h2 className="font-weight-bold">Order List</h2>
            <OrdersSearchForm onSubmit={fetchOrdersWithFilters} />
          </Col>
        </Row>
        <Row className="mt-4">
          <Col>
            <OrdersTable />
          </Col>
        </Row>
      </Container>
      <OrderDetailsModal />
    </AppContext.Provider>
  );
}

export default App;
