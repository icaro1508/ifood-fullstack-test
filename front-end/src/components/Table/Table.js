import React from 'react'
import PropTypes from 'prop-types'

import BootstrapTable from 'react-bootstrap/Table'

import Head from './Head'
import Header from './Header'
import Body from './Body'
import Row from './Row'
import Cell from './Cell'

const Table = ({ render, headers, rows }) => {
    return (
        <BootstrapTable striped bordered hover responsive>
            {render({ headers, rows })}
        </BootstrapTable>
    )
}

Table.propTypes = {
    render: PropTypes.func.isRequired,
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

export class HeaderFactory {
    buildHeader(text, key, rendered = true) {
        return { text, key, rendered }
    }
}