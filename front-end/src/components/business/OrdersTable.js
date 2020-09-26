import React, { useCallback, useContext, useMemo } from 'react'

import { AppContext, actionCreators } from 'context/AppContext'
import Table, { HeaderFactory } from 'components/Table'
import useFormatCurrency from 'hooks/useFormatCurrency'

import moment from 'moment'

const OrdersTable = () => {
    const factory = new HeaderFactory()
    const currencyFormatter = useFormatCurrency()

    const headers = useMemo(() => [
        factory.buildHeader({ text: 'Date', key: 'createdAt', renderFn: ({ value, getCellId }) => <Table.Cell key={getCellId()}>{moment(value).format('DD/MM')}</Table.Cell> }),
        factory.buildHeader({ text: 'Client Name', key: 'client', renderFn: ({ value, getCellId }) => <Table.Cell key={getCellId()}>{(value?.name || '')}</Table.Cell> }),
        factory.buildHeader({ text: 'Phone', key: 'client', renderFn: ({ value, getCellId }) => <Table.Cell key={getCellId()}>{(value?.phone || '')}</Table.Cell> }),
        factory.buildHeader({ text: 'E-mail', key: 'client', renderFn: ({ value, getCellId }) => <Table.Cell key={getCellId()}>{(value?.email || '')}</Table.Cell> }),
        factory.buildHeader({ text: 'Total Value', key: 'totalValue', renderFn: ({ value, getCellId }) => <Table.Cell key={getCellId()}>{currencyFormatter(value)}</Table.Cell> }),
    ], [factory, currencyFormatter])

    const { state, dispatch } = useContext(AppContext)

    const openOrderDetails = useCallback((order) => {
        console.log(order)
        const { items, client } = order
        dispatch(actionCreators.setOrderDetails({ ...client, items }))
        dispatch(actionCreators.openOrderDetailsModal())
    }, [dispatch])

    return (
        <Table
            headers={headers}
            rows={state.orders.map(order => ({ ...order }))}
            rowOnClick={openOrderDetails}
        />
    )
}

export default OrdersTable