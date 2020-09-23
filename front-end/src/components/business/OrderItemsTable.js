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
        factory.buildHeader({ text: 'Unit Price', key: 'unitPrice', renderFn: ({ value }) => <Table.Cell>{currencyFormatter(value)}</Table.Cell> }),
        factory.buildHeader({ text: 'Total', key: 'total' }),
    ], [factory])

    return (
        <Table
            headers={headers}
            rows={items}
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