import React from 'react'

const TableRow = ({ children, onClick }) => {
    return <tr onClick={e => onClick(e)}>{children}</tr>
}

TableRow.defaultProps = {
    onClick: () => { }
}

export default TableRow