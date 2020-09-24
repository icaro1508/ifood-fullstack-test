import React, { useMemo } from 'react'
import PropTypes from 'prop-types'

import Table, { HeaderFactory } from 'components/Table'
import useFormatCurrency from 'hooks/useFormatCurrency'

const OrderItemsTable = ({ items }) => {
    const factory = new HeaderFactory()
    const currencyFormatter = useFormatCurrency()

    const headers = useMemo(() => [
        factory.buildHeader({ text: 'Description', key: 'description' }),
        factory.buildHeader({ text: 'Quantity', key: 'quantity' }),
        factory.buildHeader({ text: 'Unit Price', key: 'price', renderFn: ({ value }) => <Table.Cell>{currencyFormatter(value)}</Table.Cell> }),
        factory.buildHeader({ text: 'Total', key: 'total', renderFn: ({ value }) => <Table.Cell>{currencyFormatter(value)}</Table.Cell> }),
    ], [factory, currencyFormatter])

    return (
        <Table
            headers={headers}
            rows={items.map(item => ({ ...item, total: item.quantity * item.price }))}
        />
    )
}

OrderItemsTable.propTypes = {
    items: PropTypes.array
}
OrderItemsTable.defaultProps = {
    items: []
}

export default OrderItemsTable