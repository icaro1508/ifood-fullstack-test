import React, { useCallback, useContext } from 'react'

import { AppContext } from 'context/AppContext'

import Modal from 'react-bootstrap/Modal'
import OrderItemsTable from 'components/business/OrderItemsTable'

const OrderDetailsModal = () => {
    const { state, dispatch, actionCreators } = useContext(AppContext)
    const handleHide = useCallback(() => dispatch(actionCreators.closeOrderDetailsModal()), [dispatch, actionCreators])
    return (
        <Modal
            show={state.isOrderDetailsModalOpen}
            onHide={handleHide}>
            <Modal.Header closeButton>
                <Modal.Title>Order Details</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {state.orderDetails.clientName}-{state.orderDetails.phone}-{state.orderDetails.email}
                <OrderItemsTable items={state.orderDetails.items} />
            </Modal.Body>
        </Modal>
    )
}

export default OrderDetailsModal