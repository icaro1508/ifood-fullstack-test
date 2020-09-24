import React, { useCallback, useContext } from 'react'

import { AppContext, actionCreators } from 'context/AppContext'

import Modal from 'react-bootstrap/Modal'
import OrderItemsTable from 'components/business/OrderItemsTable'

const OrderDetailsModal = () => {
    const { state, dispatch } = useContext(AppContext)
    const handleHide = useCallback(() => dispatch(actionCreators.closeOrderDetailsModal()), [dispatch])
    return (
        <Modal
            show={state.isOrderDetailsModalOpen}
            onHide={handleHide}>
            <Modal.Header closeButton>
                <Modal.Title>Order Details</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <div className="d-flex justify-content-between pb-3">
                    <span><strong>Name: </strong>{state.orderDetails.name}</span>
                    <span><strong>Phone: </strong>{state.orderDetails.phone}</span>
                    <span><strong>E-mail: </strong>{state.orderDetails.email}</span>
                </div>
                <OrderItemsTable items={state.orderDetails.items} />
            </Modal.Body>
        </Modal>
    )
}

export default OrderDetailsModal