import React, { useCallback, useContext } from 'react';

import { actionCreators, AppContext } from 'context/AppContext'

import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'

import OrdersSearchForm from 'components/business//OrdersSearchForm';
import OrdersTable from 'components/business/OrdersTable';
import OrderDetailsModal from 'components/business/OrderDetailsModal';

import client from 'api/client'
import { ORDERS_LIST } from 'api/constants/routes';

const Orders = () => {

    const { dispatch } = useContext(AppContext)

    const fetchOrders = useCallback(({ after, before, name, phone, email }) => {
        client(ORDERS_LIST, {
            params: {
                after,
                before,
                name,
                phone,
                email
            }
        }).then(res => dispatch(actionCreators.updateOrderList(res.data)))
    }, [dispatch])

    const fetchOrdersWithFilters = useCallback(filters => {
        fetchOrders(filters)
    }, [fetchOrders])

    return (
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
            <OrderDetailsModal />
        </Container>
    )
}

export default Orders