import React from 'react'

const initialState = {
    isOrderDetailsModalOpen: false,
    orders: [{ whatever: 'jesuis', date: 'asd', id: '1' }],
    orderDetails: {}
}

export const AppContext = React.createContext(initialState)

export { initialState }

const SET_ORDER_DETAILS = 'SET_ORDER_DETAILS'
const UPDATE_ORDER_LIST = 'UPDATE_ORDER_LIST'
const OPEN_ORDER_DETAILS_MODAL = 'OPEN_ORDER_DETAILS_MODAL'
const CLOSE_ORDER_DETAILS_MODAL = 'CLOSE_ORDER_DETAILS_MODAL'

export function reducer(state, action) {
    switch (action.type) {
        case SET_ORDER_DETAILS:
            return { ...state, orderDetails: action.payload }
        case UPDATE_ORDER_LIST:
            return { ...state, orders: action.payload }
        case OPEN_ORDER_DETAILS_MODAL:
            return { ...state, isOrderDetailsModalOpen: true }
        case CLOSE_ORDER_DETAILS_MODAL:
            return { ...state, isOrderDetailsModalOpen: false }
        default:
            throw new Error('Invali Action')
    }
}

export const actionCreators = {
    setOrderDetails(orderDetails) {
        return { type: SET_ORDER_DETAILS, payload: orderDetails }
    },
    updateOrderList(orders) {
        return { type: UPDATE_ORDER_LIST, payload: orders }
    },
    openOrderDetailsModal() {
        return { type: OPEN_ORDER_DETAILS_MODAL }
    },
    closeOrderDetailsModal() {
        return { type: CLOSE_ORDER_DETAILS_MODAL }
    }
}
