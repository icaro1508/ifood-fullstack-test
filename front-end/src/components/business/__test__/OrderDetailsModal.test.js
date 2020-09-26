import React from 'react'

import { render, screen } from '@testing-library/react'
import '@testing-library/jest-dom/extend-expect'

import OrderDetailsModal from 'components/business/OrderDetailsModal'
import { AppContext } from 'context/AppContext'

describe('OrderDetailsModal tests', () => {

    test('Should Render Client Information', () => {
        const state = {
            orderDetails: {
                name: 'John',
                phone: '12345',
                email: 'john@mail.com'
            },
            isOrderDetailsModalOpen: true
        }

        render(
            <AppContext.Provider value={{ state }}>
                <OrderDetailsModal />
            </AppContext.Provider>
        )

        expect(screen.queryByText('John')).toBeTruthy()
        expect(screen.queryByText('12345')).toBeTruthy()
        expect(screen.queryByText('john@mail.com')).toBeTruthy()
    })
})