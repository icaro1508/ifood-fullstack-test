import React, { useCallback, useContext, useMemo } from 'react'

import { AppContext } from 'context/AppContext'
import Table, { HeaderFactory } from 'components/Table'

const OrdersTable = () => {
    const factory = new HeaderFactory()
    const headers = useMemo(() => [
        factory.buildHeader('id', 'id', false),
        factory.buildHeader('Date', 'date'),
        factory.buildHeader('Client Name', 'clientName'),
        factory.buildHeader('Phone', 'phone'),
        factory.buildHeader('E-mail', 'email'),
        factory.buildHeader('Total Value', 'totalValue'),
    ], [factory])

    const { state, dispatch, actionCreators } = useContext(AppContext)

    function fetchOrderDetails(orderId) {
        //fetch data
        Promise.resolve()
            .then(() => {
                dispatch(actionCreators.setOrderDetails({
                    clientName: 'Jão',
                    phone: '99999',
                    email: 'mail@mail.com',
                    items: [{
                        description: 'Item 1',
                        quantity: '1',
                        unitPrice: '10 real',
                        total: '10 real'
                    }]
                }))
                dispatch(actionCreators.openOrderDetailsModal())
            })
    }

    return (
        <Table
            headers={headers}
            rows={state.orders}
            render={({ headers, rows }) => (
                <>
                    <Table.Head>
                        <Table.Row>
                            {headers.map(header => header.rendered ? <Table.Header key={header.key}>{header.text}</Table.Header> : null)}
                        </Table.Row>
                    </Table.Head>
                    <Table.Body>
                        {rows.map(order =>
                            <Table.Row
                                key={order.id}
                                onClick={() => fetchOrderDetails(order.id)}
                            >
                                {headers.map(header =>
                                    header.rendered ?
                                        <Table.Cell key={`${order.id}:${header.key}`}>{order[header.key]}</Table.Cell>
                                        : null)}
                            </Table.Row>
                        )}
                    </Table.Body>
                </>
            )} />
    )
}

export default OrdersTable