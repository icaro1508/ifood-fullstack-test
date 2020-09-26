import React from 'react'
import PropTypes from 'prop-types'

import BootstrapTable from 'react-bootstrap/Table'

import Head from './Head'
import Header from './Header'
import Body from './Body'
import Row from './Row'
import Cell from './Cell'

const Table = ({ headers, rows, rowOnClick }) => {

    return (
        <BootstrapTable striped bordered hover responsive>
            <Table.Head>
                <Table.Row>
                    {headers.map(header => <Table.Header key={header.key}>{header.text}</Table.Header>)}
                </Table.Row>
            </Table.Head>
            <Table.Body>
                {rows.map((row, index) =>
                    <Table.Row key={`${row.id}:${index}`} onClick={() => rowOnClick(row)}>
                        {headers.map((header, index) => header.renderFn({ value: row[header.key], getCellId: () => `${row.id}:${index}:${header.key}` }))}
                    </Table.Row>)}
            </Table.Body>
        </BootstrapTable>
    )
}

Table.propTypes = {
    headers: PropTypes.array.isRequired,
    rows: PropTypes.array
}
Table.defaultPropss = {
    rows: []
}

Table.Header = Header
Table.Head = Head
Table.Body = Body
Table.Row = Row
Table.Cell = Cell

export default Table
export { Head, Header, Body, Row }

class HeaderFactory {
    buildHeader({ text, key, renderFn }) {
        renderFn = renderFn || (({ value, getCellId }) => <Table.Cell key={getCellId()}>{value}</Table.Cell>)
        return { text, key, renderFn }
    }
}

export { HeaderFactory }