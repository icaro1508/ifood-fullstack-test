import React, { useMemo } from 'react'
import PropTypes from 'prop-types'

import Table, { HeaderFactory } from 'components/Table'

const OrderItemsTable = ({ items }) => {
    const factory = new HeaderFactory()
    const headers = useMemo(() => [
        factory.buildHeader('Description', 'description'),
        factory.buildHeader('Quantity', 'quantity'),
        factory.buildHeader('Unit Price', 'unitPrice'),
        factory.buildHeader('Total', 'total')
    ], [factory])

    return (
        <Table
            headers={headers}
            rows={items}
            render={({ headers, rows }) => (
                <>
                    <Table.Head>
                        <Table.Row>
                            {headers.map(header => header.rendered ? <Table.Header key={header.key}>{header.text}</Table.Header> : null)}
                        </Table.Row>
                    </Table.Head>
                    <Table.Body>
                        {rows.map(item => (
                            <Table.Row>
                                {headers.map(header => header.rendered ? <Table.Cell>{item[header.key]}</Table.Cell> : null)}
                            </Table.Row>
                        ))}
                    </Table.Body>
                </>
            )} />
    )
}

OrderItemsTable.propTypes = {
    items: PropTypes.object
}
OrderItemsTable.defaultProps = {
    items: []
}

export default OrderItemsTable